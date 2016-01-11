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

	public static int size = 0;
	public static int length = 0;

	public static void main(String args[]) {

		int a[] = { 329, 457, 657, 839, 436, 720, 1355, 1999 };

		System.out.print("Before Heap Sorting : ");
		for (int i : a) {
			System.out.print(i + " ");
		}

		System.out.println();
		// insertionSort(a);
		heapSort(a);
		System.out.print("After Heap Sorting : ");
		for (int i : a) {
			System.out.print(i + " ");
		}

	}

	private static int left(int i) {
		return (2 * i + 1);
	}

	private static int right(int i) {
		return (2 * i + 2);
	}

	private static int parent(int i) {
		return (i - 1) / 2;
	}

	private static void heapSort(int[] a) {
		length = a.length - 1;
		size = length;
		buildMaxHeap(a);

		for (int i = size; i > 0; i--) {
			
			int n = a[i];
			a[i] = a[0];
			a[0] = n;
			size--;
			maxHeapify (a, 0);
		}
	}

	private static void buildMaxHeap(int [] a) {
		
		int p = parent (a.length-1);
		int max = p;
		
		for (int i = p; i >=0; i--) {
			maxHeapify (a, i);
		}
	}

	private static void maxHeapify(int[] a, int p) {

			int l = left(p);
			int r = right(p);
			
			int max = p;
			if (l<=size && a[l]>a[p]) {
				max = l;
			}
			
			if (r <= size && a[r] > a[max]) {
				max = r;
			}
			
			if (max != p) {
				int n = a[max];
				a[max] = a[p];
				a[p] = n;
				maxHeapify (a, max);
			}
	}

}