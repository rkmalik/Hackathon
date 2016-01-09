package ch32_accountusinglocks;

import java.util.concurrent.locks.*;

public class Account {
	
	private int deposit;
	private static Lock lock = new ReentrantLock();
	
	public Account () {
		this.deposit = 0;
	}
	
	public void deposit (int pennies) {
		lock.lock();
		
		try {
			Thread.sleep(15);
			deposit+= pennies;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}
	
	public int getBalance () {
		return deposit;
	}
}
