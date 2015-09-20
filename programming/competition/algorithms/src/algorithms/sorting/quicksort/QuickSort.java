package algorithms.sorting.quicksort;

/**
 * Reference: Thomas corman Introduction to algorithms.
 * 
 */
public class QuickSort {

    public void sort(
            int arr[]) {

        int start = 0;
        int end = arr.length-1;

        quickSort(arr, start, end);
    }

    public void quickSort(
            int[] arr,
            int start,
            int end) {
        
        
        if (start < end) {
            int index = partition(arr, start, end);
            quickSort(arr, start, index-1);
            quickSort(arr, index+1, end);         
        }
    }
    
    public int partition(int [] arr, int start, int end) {
        
        int pivot = arr[end];
        
        /**
         * Start the loop from the first element and loop till the last but one.
         * Becasue the last element which is pivot will be swapped to the i+1 element
         * As, after the loop the left elements will he smaller than the pivot and the 
         * right elements will greater than the pivot. 
         * */
        int partitionIndex = start -1;  // important Point 1
        
        for (int i = start; i < end; i++) {
            
            if (arr[i] < pivot) {   // important Point 2
                
                partitionIndex++;
                int data = arr [i];
                arr[i] = arr[partitionIndex];
                arr[partitionIndex] = data;
            }
        }
        arr[end] = arr[++partitionIndex];
        arr[partitionIndex] = pivot;
        return partitionIndex;
    }
}
