package a_ch11sortingsearching;

public class QuickSort2 {

	public static void main(String[] args) {

		int arr[] = { 22, 11, 4, 7, 15, 32, 23};

		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();

		sort(arr);

		for (int i : arr) {
			System.out.print(i + " ");
		}
	}

	public static void sort(int arr[]) {

		// The first step is to partition the array and set the pivot on the
		// right place.
		quickSort(arr, 0, arr.length - 1);
	}

	private static void quickSort(int[] a, int l, int h) {

		int index = partition(a, l, h);

		// by now the index value is at its correct position.
		if (l < index-1) {
			quickSort(a, l, index - 1);
		}

		if (h > index+1)
			quickSort(a, index + 1, h);
	}

	private static int partition(int[] a, int l, int h) {
		
		int pivot = a[(l + h) / 2];

		while (l <= h) {
			while (a[l] < pivot)
				l++;

			while (a[h] > pivot)
				h--;

			if (a[l] > a[h]) {

				int t = a[l];
				a[l] = a[h];
				a[h] = t;
				l++;
				h--;
			}
		}
		return l;
	}

}