package a_ch11sortingsearching;

public class SelectionSort2 {

	public static void main (String args []) {
		
		//int a [] = {329, 457, 657, 839, 436, 720, 1355, 1999};
		int a[] = { 22, 11, 4, 7, 15, 32, 23 };
		
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println("");
		
		selectionSort(a);
		
		for (int i : a) {
			System.out.print(i + " ");
		}
		
	}
	
	public static void selectionSort(int a[]) {

		for (int i = 0; i < a.length-1; i++) {
			
			int min = i;
			
			for (int j = i+1; j<=a.length-1; j++) {
				if (a[j] < a [min]) {
					min = j;
				}
			}
			
			if (min != i) {
				
				int n = a[i];
				a[i] = a[min];
				a[min] = n;
			}
		}
	}
}