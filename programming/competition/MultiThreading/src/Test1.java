 
 public class Test1 extends Thread {
	 
	 public static void main (String args []) {
		 
		Test1 testThread = new Test1 ();
		testThread.start ();
		
		System.out.println ("Hi Testing main thread");
		System.out.println ("Hi Testing main thread");
		System.out.println ("Hi Testing main thread");
		
		int result = 99/0;
		
		 
		 
	 }
	 
	 public void run () {
		 
		System.out.println ("Hi Testing child thread"); 
		System.out.println ("Hi Testing child thread"); 
		System.out.println ("Hi Testing child thread"); 
//		int result = 99/0;
		 
	 }
	 
	 
 }