package a_ch11sortingsearching;

public class QuickSort {
	
	public static void main(String[] args) {

		int arr[] = { 22, 11, 4, 7, 15, 32, 23, 11, 11 };

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

	public static void quickSort(int arr[], int left, int right) {

		int index = partition(arr, left, right);

		if (left < index - 1) {
			quickSort(arr, left, index - 1);
		}

		if (index < right) {
			quickSort(arr, index, right);
		}
	}

	public static int partition(int arr[], int left, int right) {

		int pivot = arr[(left + right) / 2];

		while (left <= right) {

			while (arr[left+1] < pivot)
				left++;
			while (arr[right] > pivot)
				right--;

			if (left <= right) {

				int temp = arr[left];
				arr[left] = arr[right];
				arr[right] = temp;
				left ++;
				right--;
			}
		}
		return left;
	}

}