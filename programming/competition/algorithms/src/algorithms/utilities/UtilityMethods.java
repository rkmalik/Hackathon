package algorithms.utilities;


public class UtilityMethods {
    
    public static void swap (int [] arr, int srcIndex, int destIndex) {
        int data = arr[srcIndex];
        arr[srcIndex] = arr[destIndex];
        arr[destIndex] = data;
    }

}
