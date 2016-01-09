package ch32_accountusingconditionallock;

import java.util.Random;

class DepositThread implements Runnable {
	
	private Account account;
	
	public DepositThread (Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		
		Random rand = new Random();
		// Below specifies the number of deposits. 
		int depositCount = rand.nextInt(100);
		// 
		int total = 0;
		
		try {

			while (--depositCount>=0) {
				int amount = rand.nextInt(100);
				account.deposit(amount);
				
				System.out.println("Deposited : " + amount);
				
				total+= amount;
				Thread.sleep(100);
			}
			System.out.println("Total Amount deposited : " + total);
		} catch (InterruptedException e) {
			
		}
		
		
	}
}
