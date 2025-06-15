package GameEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class GameWindow extends JPanel {
    HashMap<Integer, Coordinate> points = new HashMap<>();
    boolean isMoving = false;
    final int MOVE_SPEED = 10;

    public GameWindow(int width, int height) {
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);

        addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                Coordinate current = points.get(0);
                Coordinate newPos = null;

                switch(e.getKeyCode()) {
                    case KeyEvent.VK_LEFT:
                        newPos = new Coordinate(
                                Math.max(0, current.xPos - MOVE_SPEED),
                                current.yPos
                        );
                        break;
                    case KeyEvent.VK_RIGHT:
                        newPos = new Coordinate(
                                Math.min(width - 10, current.xPos + MOVE_SPEED),
                                current.yPos
                        );
                        break;
                    case KeyEvent.VK_UP:
                        newPos = new Coordinate(
                                current.xPos,
                                Math.max(0, current.yPos - MOVE_SPEED)
                        );
                        break;
                    case KeyEvent.VK_DOWN:
                        newPos = new Coordinate(
                                current.xPos,
                                Math.min(height - 10, current.yPos + MOVE_SPEED)
                        );
                        break;
                }

                if (newPos != null) {
                    points.put(0, newPos);
                    repaint();
                }
            }
        });
    }

    public void addPoint(int xPos, int yPos, int id) {
        Coordinate coords = new Coordinate(xPos, yPos);
        points.put(id, coords);
    }

    public void getPointData() {
        for (Map.Entry<Integer, Coordinate> entry : points.entrySet()) {
            Integer id = entry.getKey();
            Coordinate coord = entry.getValue();

            System.out.println("ID: " + id + "\tCoordinates: " + coord);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.fillRect(points.get(0).xPos, points.get(0).yPos, 10, 10);

        drawBoundingBox(g,new Coordinate(5, 5), 500, 500);
    }

    public void drawBoundingBox(Graphics g, Coordinate startCoords, int width, int height) {
        g.fillRect(startCoords.xPos, startCoords.yPos, 1, height);
        g.fillRect(startCoords.xPos, startCoords.yPos, width, 1);
        g.fillRect(width + startCoords.xPos, startCoords.yPos, 1, height);
        g.fillRect(startCoords.xPos, height + startCoords.yPos, width, 1);
    }

    public void startMovement() {
        isMoving = true;
        Thread movementThread = new Thread(() -> {
            try {
                while (isMoving && points.get(0).yPos < 490) {
                    SwingUtilities.invokeLater(() -> {
                        points.put(0, new Coordinate(points.get(0).xPos, points.get(0).yPos + 10));
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
