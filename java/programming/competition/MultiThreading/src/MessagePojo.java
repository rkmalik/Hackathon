
public class MessagePojo {
	
	private String msg;
	
	public void setMsg (String msg) {
		this.msg = msg;
	}
	
	public String getMsg() {
		return this.msg;
	}
	
	public synchronized void call (String message) {
		
		try {
			System.out.print("[" + message);
			Thread.sleep(1000);
			
		} catch (InterruptedException e) {
			
			System.out.println(e);
		}
		
		System.out.println("]");
	}

}
