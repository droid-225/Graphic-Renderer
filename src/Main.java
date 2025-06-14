import javax.swing.*;
import java.awt.*;

public class Main {
	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			JFrame frame = new JFrame("Plot");
			Plotter plotter = new Plotter(520, 540);

			plotter.addPoint(1, 1, 0);
			//plotter.addPoint(500, 500, 1);
			//plotter.addPoint(50, 50, 2);

			JButton startButton = new JButton("Start Movement");
			startButton.addActionListener(e -> plotter.startMovement());

			frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame.getContentPane().add(plotter, BorderLayout.CENTER);
			frame.getContentPane().add(startButton, BorderLayout.SOUTH);
			frame.pack();
			frame.setLocationRelativeTo(null);
			frame.setVisible(true);
		});
	}
}