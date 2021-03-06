package a_ch11sortingsearching;

public class InsertionSort {

	public static void main(String args[]) {

		int a[] = { 329, 1355, 1999, 457, 839, 436, 720, 657 };

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

	public static void insertionSort(int arr[]) {

		for (int i = 1; i < arr.length; i++) {

			int num = arr[i];
			int j = i - 1;
			while (j >= 0 && num < arr[j]) {
				arr[j + 1] = arr[j];
				j--;
			}
			arr[j + 1] = num;
		}
	}
}