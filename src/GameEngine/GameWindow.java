package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class GameWindow extends JPanel {
    HashMap<Integer, Coordinate> players = new HashMap<>();
    HashMap<Integer, Coordinate> others = new HashMap<>();
    HashMap<Integer, Coordinate> Obstacle = new HashMap<>();
    boolean isMoving = false;
    final int MOVE_SPEED = 10;
    int width, height;

    public GameWindow(int width, int height) {
        this.width = width;
        this.height = height;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);

        addController(0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(players.get(0).getXPos(), players.get(0).getYPos(), 10, 10);

        //drawBoundingBox(g,new Coordinate(5, 5), 500, 500);
    }

    public void addController(int entityID) {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Coordinate entity = players.get(entityID);
                Coordinate newPos = switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> new Coordinate(Math.max(0, entity.getXPos() - MOVE_SPEED), entity.getYPos());
                    case KeyEvent.VK_RIGHT -> new Coordinate(Math.min(width - 10, entity.getXPos() + MOVE_SPEED), entity.getYPos());
                    case KeyEvent.VK_UP -> new Coordinate(entity.getXPos(), Math.max(0, entity.getYPos() - MOVE_SPEED));
                    case KeyEvent.VK_DOWN -> new Coordinate(entity.getXPos(), Math.min(height - 10, entity.getYPos() + MOVE_SPEED));
                    default -> null;
                };

                if (newPos != null) {
                    players.put(entityID, newPos);
                    getPointData();
                    repaint();
                }
            }
        });
    }

    public void addPoint(int xPos, int yPos, int id) {
        Coordinate coords = new Coordinate(xPos, yPos);
        players.put(id, coords);
    }

    public void getPointData() {
        for (Map.Entry<Integer, Coordinate> entry : players.entrySet()) {
            Integer id = entry.getKey();
            Coordinate coord = entry.getValue();

            System.out.println("ID: " + id + "\tCoordinates: " + coord);
        }
    }

    public void drawBoundingBox(Graphics g, Coordinate startCoords, int width, int height) {
        g.fillRect(startCoords.getXPos(), startCoords.getYPos(), 1, height);
        g.fillRect(startCoords.getXPos(), startCoords.getYPos(), width, 1);
        g.fillRect(width + startCoords.getXPos(), startCoords.getYPos(), 1, height);
        g.fillRect(startCoords.getXPos(), height + startCoords.getYPos(), width, 1);
    }

    public void startMovement() {
        isMoving = true;
        Thread movementThread = new Thread(() -> {
            try {
                while (isMoving && players.get(0).getYPos() < 490) {
                    SwingUtilities.invokeLater(() -> {
                        players.put(0, new Coordinate(players.get(0).getXPos(), players.get(0).getYPos() + 10));
                        repaint();
                    });
                    Thread.sleep(100);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        movementThread.start();
    }
}
