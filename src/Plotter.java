import GameEngine.Coordinate;

import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class Plotter extends JPanel {
    HashMap<Integer, Coordinate> points = new HashMap<>();
    int winWidth;
    int winHeight;
    boolean isMoving = false;

    public Plotter(int width, int height) {
        winWidth = width;
        winHeight = height;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
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

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        //for(Map.Entry<Integer, GameEngine.Coordinate> entry: points.entrySet())
        g.fillRect(points.get(0).xPos, points.get(0).yPos, 10, 10);

        drawBoundingBox(g, new Coordinate(1,1), 500, 500);
    }

    public void drawBoundingBox(Graphics g, Coordinate startCoords, int width, int height) {
        g.fillRect(startCoords.xPos, startCoords.yPos, 1, height);
        g.fillRect(startCoords.xPos, startCoords.yPos, width, 1);
        g.fillRect(width, startCoords.yPos, 1, height);
        g.fillRect(startCoords.xPos, height, width, 1);
    }
}
