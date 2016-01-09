package ch32_account;
import javax.swing.*;

public class FlashingText extends JApplet implements Runnable {
	private JLabel jlblText = new JLabel("Welcome", JLabel.CENTER);

	public FlashingText() {
		add(jlblText);
		new Thread(this).start();
	}

	@Override /** Set the text on/off every 200 milliseconds */
	public void run() {
		try {
			while (true) {
				if (jlblText.getText() == null)
					jlblText.setText("Hello Rohit!");
				else
					jlblText.setText(null);
				Thread.sleep(200);
				/*
				 * implements Runnable create a label add a label start a thread
				 * how to run sleep
				 */
			}
		} catch (InterruptedException ex) {
		}
	}
	
	public static void main (String args []) {
		
		FlashingText ft = new FlashingText ();
	}
}