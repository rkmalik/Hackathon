package informatica;

public class FibonacciNumbers {
	
	public static int [] arr = new int [11];
	static int n = 10;
	
	public static void main (String args []) {
		

		fib (10);
		
		for (int i = 1; i <= n; i++) {
			System.out.print(arr[i] + "  " );
		}
	}
	
	static int fib (int i) {
		
		if (i==0) {
			arr[i] = 0;
			return 0;
		}
			
		if (i == 1 || i ==2) {
			arr[i] = 1;
			return 1;
		}
		
		
		if (arr[i]==0)  {
			arr[i] = fib(i-1) + fib(i-2);
		}
		return arr[i];
	}
	

}
