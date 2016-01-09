package ch32_account;
/*package ch32;

public class ClockWithAudioOnSeparateThread extends JApplet {
	// Same as in lines 7-62 in Listing 32.4, so omitted omitted
	*//** Announce the current time at every minute *//*
	public void announceTime(int h, int m) {
		new Thread(new AnnounceTimeOnSeparateThread(h, m)).start();
	}

	*//** Inner class for announcing time *//*
	class AnnounceTimeOnSeparateThread implements Runnable {
		private int hour, minute;

		*//** Get audio clips *//*
		public AnnounceTimeOnSeparateThread(int hour, int minute) {
			this.hour = hour;
			this.minute = minute;
		}

		@Override
		public void run() {
			// Announce hour
			hourAudio[hour % 12].play();
			try {
				// Time delay to allow hourAudio play to finish
				Thread.sleep(1500);
				// Announce minute
				minuteAudio[minute].play();
				// Time delay to allow minuteAudio play to finish
				Thread.sleep(1500);
			} catch (InterruptedException ex) {
			}
			// Announce am or pm
			if (hour < 12)
				amAudio.play();
			else
				pmAudio.play();
		}
	}
}*/