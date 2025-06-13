import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Plotter extends JPanel {
    HashMap<Integer, Coordinate> points = new HashMap<>();
    int winWidth;
    int winHeight;

    public Plotter(int width, int height) {
        winWidth = width;
        winHeight = height;

        JFrame frame = new JFrame("Plot");
        frame.setSize(winWidth, winHeight);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.add(this);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
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

        g.setColor(Color.BLACK);
        for(Map.Entry<Integer, Coordinate> entry: points.entrySet())
            g.fillRect(entry.getValue().xPos, entry.getValue().yPos, 10, 10);

        g.fillRect(1, 1, 1, 500);
        g.fillRect(1, 1, 500, 1);
        g.fillRect(500, 1, 1, 500);
        g.fillRect(1, 500, 500, 1);
    }
}
