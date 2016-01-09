package ch32_accountusingconditionallock;

import java.util.Random;

public class WithdrawlThread implements Runnable {

	private Account account;

	public WithdrawlThread(Account account) {
		this.account = account;
	}

	public void run() {

		Random rand = new Random();
		// Below specifies the number of deposits.
		int withdrawCount = rand.nextInt(50);
		//
		int totalWithdrawl = 0;

		try {
			
			while (--withdrawCount>=0) {
				int withdrawlAmount = rand.nextInt(100);
				account.withdraw(withdrawlAmount);

				System.out.println("Withdrew : " + withdrawlAmount);

				totalWithdrawl += withdrawlAmount;
				Thread.sleep(100);
			}
			System.out.println("Total Amount withdrew : " + totalWithdrawl);
		} catch (InterruptedException e) {
			
		}
		
		
	}

}
