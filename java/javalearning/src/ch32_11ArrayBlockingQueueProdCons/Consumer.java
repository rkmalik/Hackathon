package ch32_11ArrayBlockingQueueProdCons;

public class Consumer implements Runnable {
	private SharedBuffer buf = null;
	
	public Consumer (SharedBuffer buf) {
		this.buf = buf;
	}

	@Override
	public void run() {
		int count = 0;
		while (count++ < 10) {
			System.out.println("Consumer Reading...");
			int removedItem = buf.remove();
			System.out.println("Consumer Read : " + removedItem);
		}
	}

}
