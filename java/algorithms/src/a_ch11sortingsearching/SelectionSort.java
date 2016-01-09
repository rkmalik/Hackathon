package a_ch11sortingsearching;

public class SelectionSort {

	public static void main (String args []) {
		
		int a [] = {329, 457, 657, 839, 436, 720, 1355, 1999};
		
		selectionSort(a);
		
		for (int i : a) {
			System.out.print(i + " ");
		}
		
	}
	
	public static void selectionSort(int arr[]) {

		for (int i = 0; i < arr.length - 1; i++) {
			int min = i;
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[j] < arr[min])
					min = j;
			}

			if (min != i) {
				int temp = arr[i];
				arr[i] = arr[min];
				arr[min] = temp;
			}
		}
	}
}