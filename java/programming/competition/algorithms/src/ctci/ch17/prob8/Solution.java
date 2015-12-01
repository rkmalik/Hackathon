package ctci.ch17.prob8;
import java.io.*;

class Solution {
	public static void main (String[] args) {
		//code
		int a[] = {-2, -3, 4, -1, -2, 1, 5, -3};
        int max_sum = maxSubArraySum(a);
        System.out.println("Maximum contiguous sum is " +  max_sum);
	}
	
	public static int maxSubArraySum(int arr[])
    {
        int maxSoFar = 0;
        int maxEndingHere = 0;
        
        for (int i = 0; i < arr.length; i++) {
            
            maxEndingHere += arr[i];
            
            if (maxEndingHere < 0) 
                maxEndingHere = 0;
            
            if (maxEndingHere > maxSoFar) {
                
                maxSoFar = maxEndingHere;
            }
            
            
        }
        return maxSoFar;
    } 
}