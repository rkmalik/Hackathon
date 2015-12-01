

public class DemoRunnable implements Runnable {
	
	Thread t;
	String threadName;
	MessagePojo msg; 
	
	public Thread getT() {
		return t;
	}
	
	public DemoRunnable(String threadName, MessagePojo msg) {
		this.threadName = threadName;
		this.msg = msg;
		t = new Thread(this, threadName);
		t.start();
	}

	public void run() {
		System.out.println(threadName);
		
		msg.call (threadName);
	}
}
