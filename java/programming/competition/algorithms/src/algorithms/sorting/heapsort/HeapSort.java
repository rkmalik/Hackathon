package algorithms.sorting.heapsort;

import algorithms.utilities.UtilityMethods;

/**
 * HeapSort is a 3 level Process, Build Max/Min Heap, MaxHeapify/MinHeapify, Sort.
 * 
 */
public class HeapSort {

    /**
     * This variable specifies the length of the Array which needs to be sorted. As in Heap sort the first element to be
     * placed at its correct position is the last element.
     */
    int size;

    public void sort(
            int arr[]) {

        size = arr.length-1;

        buildMaxHeap(arr);
        
        /**
         * Loop to sort all the elements in the heap and put them at the correct
         * position.
         * */
        for (int i = size; i > 0; i--) {
            
            /**
             * Swap the first element with the last element as the first element is the
             * largest element of the heap.
             * 
             * Then Again maxHeapify with one lesser element. 
             * */
            UtilityMethods.swap(arr, 0, size);
            size--;
            maxHeapify(arr, 0);
        }
    }

    private int left(
            int index) {
        return (2 * index+1);
    }

    private int right(
            int index) {
        return (2 * index + 2);
    }

    private int parent(
            int index) {
        return index/2;
    }

    private void buildMaxHeap(
            int[] arr) {
        
        int length = arr.length-1;
        
        for (int i = length/2; i >= 0; i--) {
            maxHeapify(arr, i);
        }
    }

    private void maxHeapify(
            int[] arr, int index) {
        
        int left = left(index);
        int right = right(index);
        
        int largest = index;
        
        if (left<= size && arr[largest] < arr[left]) {
            largest = left;
        }
        
        if (right <= size && arr[largest] < arr[right]) {
            largest = right;
        }
        
        if (largest != index) {
            UtilityMethods.swap(arr, index, largest);
            maxHeapify(arr, largest);
        }
    }
}
