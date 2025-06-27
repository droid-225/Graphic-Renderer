/*
*  Author: Rishit Shah
*  File Name: StaticGraphics.java
*  Purpose: A graphics "engine" that only works with drawing static graphics onto the window,
*           such as text or designs.
*  Start: 6/27/2025
*/
import javax.swing.*;
import java.awt.*;

public class StaticGraphics extends JPanel {
    int width, height;

    StaticGraphics(int width, int height) {
        this.width = width;
        this.height = height;

        setBackground(Color.WHITE);
        setPreferredSize(new Dimension(width, height));
        setFocusable(true);
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Static Graphics");
            StaticGraphics window = new StaticGraphics(510, 510);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(window);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        g.setColor(Color.BLACK);
        //drawSquare(g, 10, 10, 100, 100);
        drawRainbowSquare(g, 10, 10, 490, 490);
    }

    public void drawSquare(Graphics g, int startXPos, int startYPos, int width, int height) {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                g.fillRect(startXPos + i, startYPos + j, 1, 1);
            }
        }
    }

    public void drawRainbowSquare(Graphics g, int startXPos, int startYPos, int width, int height) {
        int r;
        int gr;
        int b;

        for(int i = 0; i < width; i++) {
            r = (int)(Math.random() * 255);
            gr = (int)(Math.random() * 255);
            b = (int)(Math.random() * 255);

            for(int j = 0; j < height; j++) {
                g.setColor(new Color(r, gr, b));
                g.fillRect(startXPos + i, startYPos + j, 1, 1);
            }
        }
    }
}
