package algorithms.utilities;


public class UtilityMethods {
    
    public static void swap (int [] arr, int srcIndex, int destIndex) {
        int data = arr[srcIndex];
        arr[srcIndex] = arr[destIndex];
        arr[destIndex] = data;
    }
    
    public static int max(int item1, int item2) {
        
        int max = item1;
        
        if (item1 < item2) 
            max = item2;
        
        return max;
    }

    public static int min(int item1, int item2) {
        
        int min = item1;
        
        if (item2 < item1) 
            min = item2;
        
        return min;
    }
    
    public static int difference(int item1, int item2) {
        
        if (item1 > item2)
            return (item1-item2);
        else 
            return (item2-item1);
        
    }

}
