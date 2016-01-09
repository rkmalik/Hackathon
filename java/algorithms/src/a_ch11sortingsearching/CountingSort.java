package a_ch11sortingsearching;

public class CountingSort {

	
	public static void main (String args []) {
		
		int a [] = {9, 2, 3, 4,5,6,0,1,2,3,4,5,6,9,8,7,6,5};

		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		
		int [] b = countSort (a);
		
		for (int i : b) {
			System.out.print(i + " ");
		}
	}
	
	
	public static int [] countSort(int a[]) {

		int b[] = new int[a.length];
		int maxdig = findMaxDig(a);
		int c[] = new int[maxdig + 1];

		//

		for (int i : a) {
			c[i]++;
		}

		for (int i = 1; i < c.length; i++) {
			c[i] += c[i - 1];
		}

		for (int i = a.length - 1; i >= 0; i--) {

			b[c[a[i]]-1] = a[i];
			c[a[i]]--;
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