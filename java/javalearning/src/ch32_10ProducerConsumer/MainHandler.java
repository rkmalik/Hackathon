package ch32_10ProducerConsumer;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class MainHandler {
	
	public static void main (String args []) {
		
		ExecutorService executor = Executors.newFixedThreadPool(2);
		
		SharedBuffer buf = new SharedBuffer ();
		
		executor.execute(new Producer(buf));
		executor.execute(new Consumer(buf));
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {}
		buf.displayData();
	}
}
