package ch32_accountusingconditionallock;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;


// SECTION: 32.12

//This contain 100 instances of AddPennyTask and an instance of Account
public class AccountWithReentrantConditionalLock {

	private static Account account = new Account();

	public static void main(String args[]) {

		
		System.out.println("Starting the Transactions...");
		
		// Below are the two methods to use the Thread pool
		//ExecutorService executor = Executors.newCachedThreadPool();
		ExecutorService executor = Executors.newFixedThreadPool(5);

		
		// The deposit thread will run n number of times to deposit money to the account
		executor.execute(new DepositThread(account));
		// The withdraw thread will withdraw money from the account  
		executor.execute(new WithdrawlThread(account));
		
		executor.shutdown();
		
		while (!executor.isTerminated()) {
			
		}

		System.out.println("Total balance : " + account.getBalance());
		System.out.println("Completed all Transactions!");
	}
}
