package a_ch11sortingsearching;

public class InsertionSort2 {

	public static void main(String args[]) {

		int a[] = { 329, 457, 657, 839, 436, 720, 1355, 1999 };

		System.out.print("Before Sorting : ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		insertionSort(a);
		System.out.print("After Sorting : ");
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

	public static void insertionSort(int a[]) {

		for (int i = 1; i < a.length; i++) {
			
			
			int num = a[i];
			int j = i-1;
			
			while (j>=0 && a[j]> num) {
				a[j+1] = a[j];
				j--;
			}
			a[j+1] = num;
		}
	}
}