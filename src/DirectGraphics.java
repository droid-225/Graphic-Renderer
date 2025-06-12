import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class DirectGraphics extends JPanel {
    private boolean[][] pixels = new boolean[400][300];

    public DirectGraphics() {
        addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                int x = e.getX();
                int y = e.getY();

                // Toggle pixel state
                pixels[x][y] = !pixels[x][y];
                repaint();
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // Draw pixels manually
        for (int x = 0; x < 400; x++) {
            for (int y = 0; y < 300; y++) {
//                if (pixels[x][y]) {
//                    g.setColor(Color.BLACK);
//                    g.fillRect(x, y, 10, 10);
//                }
                g.setColor(Color.BLACK);
                g.fillRect(10, 10, 10, 10);
            }
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Direct Graphics");
            frame.setSize(500, 500);
            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.add(new DirectGraphics());
            //frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}