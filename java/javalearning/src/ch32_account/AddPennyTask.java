package ch32_account;

class AddPennyTask implements Runnable {
	
	private Account account;
	
	public AddPennyTask (Account account) {
		this.account = account;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		synchronized (account) {
			account.deposit(1);
		}
		
	}
}
