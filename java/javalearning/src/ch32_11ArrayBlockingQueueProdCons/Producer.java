package ch32_11ArrayBlockingQueueProdCons;

import java.util.Random;

public class Producer implements Runnable {
	
	private SharedBuffer buf = null;
	
	public Producer (SharedBuffer buf) {
		this.buf = buf;
	}

	@Override
	public void run() {
		int count = 0;
		while (count++ < 20) {
			int itemAdded = new Random().nextInt(100);
			System.out.println("Producer Writing...");
			buf.add(itemAdded);
			System.out.println("Producer Wrote : " + itemAdded);
		}
	}

}
