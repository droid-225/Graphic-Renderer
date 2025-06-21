package PhysicsEngine;

import javax.swing.*;

public class PhysicsHandler {
    public void start() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game");
            RenderWindow window = new RenderWindow(510, 510);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(window);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}