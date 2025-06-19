package GameEngine;

import GameEngine.Entities.Obstacle;
import GameEngine.Entities.Other;
import GameEngine.Entities.Player;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class GameWindow extends JPanel {
    private Player player = new Player(0, new Coordinate(1,1), 50, 50);
    private HashMap<Integer, Other> others = new HashMap<>();
    private HashMap<Integer, Obstacle> obstacle = new HashMap<>();
    final int MOVE_SPEED = 10;
    int width, height;
    private boolean isMoving = false;
    private final int GAME_SPEED = 50;

    public GameWindow(int width, int height) {
        this.width = width;
        this.height = height;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);

        others.put(0, new Other(1, new Coordinate(5, 5), 10, 10));
        others.put(1, new Other(2, new Coordinate(20, 5), 10, 20));
        others.put(2, new Other(3, new Coordinate(35, 5), 10, 30));
        others.put(3, new Other(4, new Coordinate(50, 5), 10, 40));
        //addController();
        startMovement(others.get(0));
        startMovement(others.get(1));
        startMovement(others.get(2));
        startMovement(others.get(3));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x, y, w, h = 0;

        for(Map.Entry<Integer, Other> entry: others.entrySet()) {
            x = entry.getValue().getPosition().getXPos();
            y = entry.getValue().getPosition().getYPos();
            w = entry.getValue().getWidth();
            h = entry.getValue().getHeight();
            g.fillRect(x, y, w, h);
        }
        //g.fillRect(player.getPosition().getXPos(), player.getPosition().getYPos(), player.getWidth(), player.getHeight());
        //g.fillRect(players.get(0).getXPos(), players.get(0).getYPos(), 10, 10);

        //drawBoundingBox(g,new Coordinate(5, 5), 500, 500);
    }

    public void startMovement(Other other) {
        isMoving = true;
        Thread movementThread = new Thread(() -> {
            try {
                while (isMoving && other.getPosition().getYPos() < (width - 10 - other.getHeight())) {
                    SwingUtilities.invokeLater(() -> {
                        other.setPosition(new Coordinate(other.getPosition().getXPos(), other.getPosition().getYPos() + MOVE_SPEED));
                        repaint();
                    });
                    Thread.sleep(GAME_SPEED);
                }
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        });
        movementThread.start();
    }

    public void addController() {
        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Coordinate entity = player.getPosition();
                Coordinate newPos = switch (e.getKeyCode()) {
                    case KeyEvent.VK_LEFT -> new Coordinate(Math.max(0, entity.getXPos() - MOVE_SPEED), entity.getYPos());
                    case KeyEvent.VK_RIGHT -> new Coordinate(Math.min(width - player.getWidth(), entity.getXPos() + MOVE_SPEED), entity.getYPos());
                    case KeyEvent.VK_UP -> new Coordinate(entity.getXPos(), Math.max(0, entity.getYPos() - MOVE_SPEED));
                    case KeyEvent.VK_DOWN -> new Coordinate(entity.getXPos(), Math.min(height - player.getHeight(), entity.getYPos() + MOVE_SPEED));
                    default -> null;
                };

                if (newPos != null) {
                    player.setPosition(newPos);
                    repaint();
                }
            }
        });
    }

    public void drawBoundingBox(Graphics g, Coordinate startCoords, int width, int height) {
        g.fillRect(startCoords.getXPos(), startCoords.getYPos(), 1, height);
        g.fillRect(startCoords.getXPos(), startCoords.getYPos(), width, 1);
        g.fillRect(width + startCoords.getXPos(), startCoords.getYPos(), 1, height);
        g.fillRect(startCoords.getXPos(), height + startCoords.getYPos(), width, 1);
    }
}
