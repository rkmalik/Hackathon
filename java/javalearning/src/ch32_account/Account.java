package ch32_account;



public class Account {
	
	private int penny;
	
	public Account () {
		this.penny = 0;
	}
	
	public void deposit (int pennies) {
		try {
			Thread.sleep(15);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		penny+= pennies;
	}
	
	public int getBalance () {
		return penny;
	}
}
