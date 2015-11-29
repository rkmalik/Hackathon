package algorithms.sorting.selectionsort;

public class SelectionSort {
    
    public void sort(int arr[]) {
        
        for (int i=0; i < arr.length; i++) {
            
            int min = i;
            // in Insertion sort each step is swapped. while in selection sort the 
            // min index is found and we swap once in a loop.
            
            for (int j = i+1; j < arr.length; j++) {
                
                if (arr[min] > arr[j]) {
                    min = j;
                }
            }
            
            int temp = arr [i];
            arr[i] = arr[min];
            arr[min] = temp;
        }
    }

}
