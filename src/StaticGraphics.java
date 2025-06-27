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
    final int PIXELSIZE = 1;
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
        //drawRainbowSquare(g, 10, 10, 490, 490);
        //drawEquilateralTriangle(g, 100, 100, 100);
        //drawRandomColoredPixels(g, 100);
        drawTriangle2(g, 100, 100, 50);
    }

    private void drawTriangle2(Graphics g, int xPos, int yPos, int height) {
        int x = 0;

        for(int i = 0; i < height; i++) {
            for(int j = 1; j <= height - x; j++)
                g.fillRect(xPos + j + x - height, yPos - i + height, PIXELSIZE, PIXELSIZE);
            x++;
        }

        for(int i = 0; i <= height; i++) {
            for(int j = 0; j <= i; j++)
                g.fillRect(xPos + j, yPos, PIXELSIZE, PIXELSIZE);

            yPos++;
        }
    }

    private void drawRandomColoredPixels(Graphics g, int numOfPixels) {
        int xPos, yPos, r, gr, b;

        for(int i = 0; i < numOfPixels; i++) {
            xPos = (int)(Math.random() * (width - 10));
            yPos = (int)(Math.random() * (height - 10));
            r = (int)(Math.random() * 255);
            gr = (int)(Math.random() * 255);
            b = (int)(Math.random() * 255);

            g.setColor(new Color(r, gr, b));
            g.fillRect(xPos, yPos, PIXELSIZE, PIXELSIZE);
        }
    }

    private void drawRandomPixels(Graphics g, int numOfPixels) {
        int xPos;
        int yPos;

        for(int i = 0; i < numOfPixels; i++) {
            xPos = (int)(Math.random() * (width - 10));
            yPos = (int)(Math.random() * (height - 10));
            g.fillRect(xPos, yPos, PIXELSIZE, PIXELSIZE);
        }
    }

    private void drawEquilateralTriangle(Graphics g, int xPos, int yPos, int height) {
        for(int j = 0; j < height; j++) {
            for(int i = 0; i < height - j; i++) {
                g.fillRect(xPos + j, yPos - i, PIXELSIZE, PIXELSIZE);
            }
        }
    }

    private void drawSquare(Graphics g, int startXPos, int startYPos, int width, int height) {
        for(int i = 0; i < width; i++) {
            for(int j = 0; j < height; j++) {
                g.fillRect(startXPos + i, startYPos + j, PIXELSIZE, PIXELSIZE);
            }
        }
    }

    private void drawRainbowSquare(Graphics g, int startXPos, int startYPos, int width, int height) {
        int r;
        int gr;
        int b;

        for(int i = 0; i < width; i++) {
            r = (int)(Math.random() * 255);
            gr = (int)(Math.random() * 255);
            b = (int)(Math.random() * 255);

            for(int j = 0; j < height; j++) {
                g.setColor(new Color(r, gr, b));
                g.fillRect(startXPos + i, startYPos + j, PIXELSIZE, PIXELSIZE);
            }
        }
    }

    private void drawWeirdLine(Graphics g, int startingXPos, int startingYPos, int height) {
        int x = 0;

        for(int i = 0; i < height; i++) {
            x = i;

            if(i > 0) {
                while(x != 0) {
                    g.fillRect(startingXPos + i, startingYPos + i, PIXELSIZE, PIXELSIZE);
                    x--;
                }
            }
        }
    }
}
