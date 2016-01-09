package a_ch11sortingsearching;

public class BinarySearchRecursive {

	public static void main(String[] args) {

		int arr[] = { 4, 7, 11, 15, 16, 23, 32 };

		for (int i : arr) {
			System.out.print(i + " ");
		}

		System.out.println();
		
		int num = 27;
		int index = findIndex(arr, num);
		System.out.println("Found " + num + " at index = " + index);
	}

	public static int findIndex(int arr[], int x) {
		return search(arr, 0, arr.length - 1, x);
	}

	public static int search(int arr[], int left, int right, int x) {

		if (left > right)
			return -1;
		int mid = (left + right) / 2;

		if (arr[mid] == x)
			return mid;

		if (x < arr[mid]) {
			return search(arr, left, mid - 1, x);
		} else {
			return search(arr, mid + 1, right, x);
		}
	}

}