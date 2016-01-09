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

	

}