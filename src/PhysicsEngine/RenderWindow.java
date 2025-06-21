package PhysicsEngine;

import javax.swing.*;
import java.awt.*;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.util.HashMap;
import java.util.Map;

public class RenderWindow extends JPanel {
    private HashMap<Integer, Entity> entities = new HashMap<>();
    final int MOVE_SPEED = 10;
    int width, height;
    private boolean isMoving = false;
    private final int GAME_SPEED = 50;

    public RenderWindow(int width, int height) {
        this.width = width;
        this.height = height;
        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);

        entities.put(0, new Entity(1, new Coordinate(5, 5), 10, 10));
        startMovement(entities.get(0));
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int x, y, w, h = 0;

        for(Map.Entry<Integer, Entity> entry: entities.entrySet()) {
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

    public void startMovement(Entity entity) {
        isMoving = true;
        Thread movementThread = new Thread(() -> {
            try {
                while (isMoving && entity.getPosition().getYPos() < (width - 10 - entity.getHeight())) {
                    SwingUtilities.invokeLater(() -> {
                        entity.setPosition(new Coordinate(entity.getPosition().getXPos(), entity.getPosition().getYPos() + MOVE_SPEED));
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

    public void drawBoundingBox(Graphics g, Coordinate startCoords, int width, int height) {
        g.fillRect(startCoords.getXPos(), startCoords.getYPos(), 1, height);
        g.fillRect(startCoords.getXPos(), startCoords.getYPos(), width, 1);
        g.fillRect(width + startCoords.getXPos(), startCoords.getYPos(), 1, height);
        g.fillRect(startCoords.getXPos(), height + startCoords.getYPos(), width, 1);
    }
}
