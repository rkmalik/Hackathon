package ch32_11ArrayBlockingQueueProdCons;

import java.util.ArrayList;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.Semaphore;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBuffer {

	private static ArrayBlockingQueue<Integer> list = new ArrayBlockingQueue<Integer>(10);

	public SharedBuffer() {

	}

	public void add(int num) {

		try {
			list.put(num);
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}
	}

	public int remove() {

		int removedItem = Integer.MIN_VALUE;

		try {
			removedItem = list.take();
		} catch (InterruptedException ex) {
			ex.printStackTrace();
		}

		return removedItem;
	}

	public void displayData() {

		System.out.println("Displaying data...");

		int size = list.size();
		for (int i = 0; i < size; i++) {
			System.out.print(list.poll());
		}
	}

}
