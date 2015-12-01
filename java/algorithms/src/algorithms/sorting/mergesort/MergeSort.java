package algorithms.sorting.mergesort;


public class MergeSort {
    
    public void sort(int[] arr) {
        
        /**
         * Case when there is no item in the array or there is 
         * only one item in the array.
         * */
        if (arr.length == 0) {
            throw new IllegalArgumentException("Array length can not be zero.");
        }
            
        if (arr.length == 1)
            return;
        
        int start = 0;
        int end = arr.length-1;
        
        mergeSort (arr, start, end);
    }
    
    private void mergeSort(int [] arr, int start, int end) {
        
        /**
         * Sort till the start is less than end
         * */
        if (start < end) {
            int q = (start + end) /2;
            
            mergeSort (arr, start, q);
            mergeSort (arr, q+1, end);
            merge (arr, start, q, end);
        }
    }
    
    private void merge (int [] arr, int start, int q, int end) {
        
        /**
         * This sorting is not an in-place sorting. we need to take a copy of the
         * data from the arr and the keep them in the left sub-array and right sub array.
         * 
         * */
        int size = q -start + 1;
        int [] left = new int [size];
        
        size = end -  q;
        int [] right = new int [size];
        
        int j = start;
        for (int i = 0; i < left.length; i++, j++) {
            left [i] = arr[j];
        }
        
        j = q+1;
        for (int i = 0; i < right.length; i++, j++) {
            right [i] = arr[j];
        }
        
        int leftIndex = 0;
        int rightIndex = 0;

        
        for (int i = start; i <= end; i ++) {
            
            if (leftIndex >= left.length) {
                arr[i] = right[rightIndex++];
                continue;
            }
            
            if (rightIndex >= right.length) {
                arr[i] = left[leftIndex++];
                continue;
            }
            
            if (left[leftIndex] < right[rightIndex]) {
                arr[i] = left[leftIndex++];
            } else {
                arr[i] = right[rightIndex++];
            }
        }
    }
}
