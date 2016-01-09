package ch32_account;

import javax.swing.JApplet;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;

public class EventDispatcherThreadDemo extends JApplet {
	public EventDispatcherThreadDemo() {
		add(new JLabel("Hi, it runs from an event dispatch thread"));
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				JFrame frame = new JFrame("EventDispatcherThreadDemo");
				frame.add(new EventDispatcherThreadDemo());
				frame.setSize(200, 200);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setLocationRelativeTo(null); // Center the frame
				frame.setVisible(true);
			}
		});
	}
}