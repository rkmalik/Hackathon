package ch32_account;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

//This contain 100 instances of AddPennyTask and an instance of Account
public class AccountWithoutSync {

	private static Account account = new Account();

	public static void main(String args[]) {

		// Below are the two methods to use the Thread pool
		ExecutorService executor = Executors.newCachedThreadPool();
		//ExecutorService executor = Executors.newFixedThreadPool(5);

		for (int i = 0; i < 100; i++) {
			executor.execute(new AddPennyTask(account));
		}
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			
		}

		System.out.println("Total amount : " + account.getBalance());
		System.out.println("Appliction Closed!");
	}
}
