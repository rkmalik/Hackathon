package algorithms.sorting.insertionsort;

public class InsertionSort {
    
    public void sort(int arr[]) {
        
        for (int i=1; i < arr.length; i++) {
            
            for (int j = i; j < arr.length; j++) {
                
                if (arr[i-1] > arr[j]) {
                    
                    int temp = arr [i-1];
                    arr[i-1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

}
