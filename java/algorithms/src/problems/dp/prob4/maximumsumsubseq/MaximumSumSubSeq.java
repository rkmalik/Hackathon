package problems.dp.prob4.maximumsumsubseq;

import java.util.Scanner;

public class MaximumSumSubSeq {
    
    private static int mss [];

    public static void main(
            String[] args) {

        int[] sequence = {-2, -3, 4, -1, -2, 1, 5, -3};
        mss = new int [sequence.length];

        int result = maximumSumSubsequence (sequence);

        System.out.println("Maximum sum subsequence is : " + result);
    }
    
    static int maximumSumSubsequence (int [] arr) {

        if (arr.length == 1)
            return arr[0];
        
        mss [0] = arr [0];
        
        for (int i = 1; i < arr.length; i++) {

            if (mss [i-1]+arr [i] > arr [i]) {
                mss [i] = mss [i-1] + arr[i];
            } else {
                mss [i] = arr[i];
            }
        }
        
        return max (mss);
    }
    
    static int max (int [] arr) {
        
        int max = arr[0];
        
        for (int i : arr) {
            if (max < i)
                max = i;
        }

        return max;
    }



}
