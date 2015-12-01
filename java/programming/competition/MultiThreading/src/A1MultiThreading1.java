/*
public class A1MultiThreading1 {
	
	
	public static void main (String args []) {
		
		Runnable demorunnable = new DemoRunnable("DemoThread", "msg");
		
		
		Thread t = Thread.currentThread();
		System.out.println(t);
		
		t.setName("CurrentMainThread");
		System.out.println("Current thread : "  + t);
		
		
			
			
			System.out.println(t.getName() + "  will sleep for 5000 ms.");
			
			try {
				for (int i = 0; i < 5; i++) {
					System.out.println("Inside main thread");
					t.sleep (5000);
					//throw new InterruptedException("Interrupting the thread forcefully");
				}
			} catch (InterruptedException e) {
				
				System.out.println("Interrupted : "  + e.getMessage());
				//t.sleep(25000);
			}
			
			System.out.println("Main thread is exiting");
	}
}
*/