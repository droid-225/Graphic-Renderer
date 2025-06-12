import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class Plotter extends JPanel {
    HashMap<Integer, Coordinate> points = new HashMap<>();
    int size;

    public Plotter() {
        JFrame frame = new JFrame("Plot");
        frame.setSize(500, 500);
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
    }
}
