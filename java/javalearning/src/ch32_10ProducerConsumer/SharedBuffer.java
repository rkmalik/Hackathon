package ch32_10ProducerConsumer;

import java.util.ArrayList;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class SharedBuffer {

	private static ArrayList<Integer> list = new ArrayList<Integer>();
	private static Lock lock = new ReentrantLock();
	private static Condition notFull = lock.newCondition();
	private static Condition notEmpty = lock.newCondition();
	private static final int SIZE = 10;
	
	public SharedBuffer () {
		
	}

	public void add(int num) {
		lock.lock();

		try {
			while (list.size()==SIZE) {
				System.out.println("Wait for notFull condition");
				notFull.await();
				//Thread.sleep(100);
			}
			
			list.add(num);
			notEmpty.signal();
		} catch (InterruptedException e)  {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public int remove() {

		lock.lock();
		int removedItem = Integer.MIN_VALUE;

		try {
			while (list.size()==0) {
				System.out.println("Wait for notEmpty condition");
				notEmpty.await();
			}
			removedItem = list.remove(0);
			notFull.signal();
			//Thread.sleep(100);
		} catch (InterruptedException e)  {
			e.printStackTrace();
		} finally {
			lock.unlock();
			return removedItem;
		}
	}
	
	public void displayData () {
		
		System.out.println("Displaying data...");
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i) + " ");
		}
	}

}
