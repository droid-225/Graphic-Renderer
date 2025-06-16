package GameEngine;

import javax.swing.*;

public class GameHandler {
    public void startGame() {
        SwingUtilities.invokeLater(() -> {
            JFrame frame = new JFrame("Game");
            GameWindow window = new GameWindow(510, 510);

            window.addPoint(5, 5, 0);

            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
            frame.getContentPane().add(window);
            frame.pack();
            frame.setLocationRelativeTo(null);
            frame.setVisible(true);
        });
    }
}