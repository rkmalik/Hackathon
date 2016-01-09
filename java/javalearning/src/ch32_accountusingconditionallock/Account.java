package ch32_accountusingconditionallock;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class Account {

	private int amount;
	private static Lock lock = new ReentrantLock();
	private static Condition condition = lock.newCondition();

	public Account() {
		this.amount = 0;
	}

	public void deposit(int amountToDeposit) {
		lock.lock();

		try {
			Thread.sleep(15);
			amount += amountToDeposit;
			condition.signalAll();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public void withdraw(int amountToWithdraw) {
		lock.lock();

		while (amountToWithdraw > amount) {
			try {
				System.out.println("Waiting....");
				condition.await();
				// condition.await(100, TimeUnit.MILLISECONDS);
				System.out.println("Woke up!");
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}

		try {
			Thread.sleep(15);
			amount -= amountToWithdraw;
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			lock.unlock();
		}
	}

	public int getBalance() {
		return amount;
	}
}
