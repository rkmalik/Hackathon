package a_ch11sortingsearching;

public class HeapSort2 {

	/**
	 * 
	 * Max Heap A[Parent(i)] >= A[i] Largest element at the root. Min Heap
	 * A[Parent(i)] <= A[i] Smallest element at the root.
	 * 
	 * MaxHeapify, BuildMaxHeap, HeapSort, MaxHeapInsert, HeapExtractMax,
	 * HeapIncreaseKey, HeapMaximum
	 * 
	 */
	
	public static void main (String args []) {
		
		int a[] = { 329, 457, 657, 839, 436, 720, 1355, 1999 };

		System.out.print("Before Heap Sorting : ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		
		System.out.println();
		//insertionSort(a);
		heapSort (a);
		System.out.print("After Heap Sorting : ");
		for (int i : a) {
			System.out.print(i + " ");
		}
		
	}

	public static void maxHeapify(int arr[], int i, int size) {

		int left = leftChild(i);
		int right = rightChild(i);

		int max = i;

		if (left <= size && arr[max] < arr[left]) {
			max = left;
		}

		if (right <= size && arr[max] < arr[right]) {
			max = right;
		}

		if (max != i) {
			int temp = arr[i];
			arr[i] = arr[max];
			arr[max] = temp;
			maxHeapify(arr, max, size);
		}

		
	}

	public static void buildMaxheap(int arr[]) {

		int lastindex = arr.length - 1;

		for (int i = lastindex / 2; i >= 0; i--) {
			maxHeapify(arr, i, arr.length - 1);
		}
	}

	public static void heapSort(int arr[]) {

		buildMaxheap(arr);

		int i = 0;
		int size = arr.length - 1;

		while (size > 0) {

			int temp = arr[0];
			arr[0] = arr[size];
			arr[size] = temp;
			size--;
			maxHeapify(arr, 0, size);
		}

	}

	private static int parent(int i) {
		return ((i - 1) / 2);
	}

	private static int leftChild(int i) {
		return (2 * i + 1);
	}

	private static int rightChild(int i) {
		return (2 * i + 2);
	}

}