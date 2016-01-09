package a_ch11sortingsearching;

public class RadixSort {

	
	public static void main (String args []) {
		
		int a [] = {329, 457, 657, 839, 436, 720, 1355, 1999};

		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		int d = 3;
		int [] b = a;
		
		for (int i = 1; i <=4; i++)
			 b = countSort (b, i);
		
		for (int i : b) {
			System.out.print(i + " ");
		}
	}
	
	// Master how to find a digit in a number.
	
	public static int [] countSort(int a[], int d) {

		int b[] = new int[a.length];
		//int maxdig = findMaxDig(a);
		int c[] = new int[10];
		int divisor = (int)Math.pow((double)10, (double)(d-1));
		
		for (int i = 0; i < a.length; i++) {
			int num = a[i];
			int dig = (num/divisor)%10;
			c[dig]++;
		}
		

		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {

			int dig = (a[i]/divisor)%10;
			
			b[c[dig]-1] = a[i];
			c[dig]--;
		}
		
		return b;
	}

	public static int findMaxDig(int[] arr) {

		int maxDig = 0;

		for (int i : arr) {

			if (maxDig < i) {
				maxDig = i;
			}

			if (maxDig == 9) {
				break;
			}
		}

		return maxDig;
	}

}