
public class A2Synchronization {
	
	
	public static void main (String args []) {
		
		MessagePojo t1obj = new MessagePojo();
		t1obj.setMsg("Synchronization1");
		MessagePojo t2obj = new MessagePojo();
		t2obj.setMsg("Synchronization2");
		
		DemoRunnable t1 = new DemoRunnable("Thread1", t1obj);
		DemoRunnable t2 = new DemoRunnable("Thread2", t1obj);
		try {
			t1.getT().join ();
			t2.getT().join();
		} catch (InterruptedException e) {
			
			System.out.println(e);
		}
		
	}

}
