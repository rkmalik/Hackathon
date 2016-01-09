package ch32_accountusinglocks;

class AddPennyTask implements Runnable {
	
	private Account account;
	
	public AddPennyTask (Account account) {
		this.account = account;
	}

	@Override
	public void run() {
			account.deposit(1);
	}
}
