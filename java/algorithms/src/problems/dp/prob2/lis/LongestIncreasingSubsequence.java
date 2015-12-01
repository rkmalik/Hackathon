package problems.dp.prob2.lis;

import java.util.Scanner;

public class LongestIncreasingSubsequence {
    
    private static int lis [];

    public static void main(
            String[] args) {

        //int [] sequence  = {2,7,3,4,9,8,12};
        /*int [] sequence  = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 1};*/
        //int[] sequence = {0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15, 1};
        /*int[] sequence = {7, 0, 9, 2, 8, 4, 1};*/
        //int[] sequence = {9, 11, 2, 13, 7, 15};
        int[] sequence = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        /*int[] sequence = {1, 2, 9, 4, 7, 3, 11, 8, 14, 6};*/
        lis = new int [sequence.length];
        int length = lis.length;
        
        for (int i = 0; i < length; i++) {
            lis[i] = 1;
        }

        int result = longestIncreasingSequence(sequence);

        System.out.println("Longest increasing sequence is : " + result);
    }

    public static int longestIncreasingSequence(
            int [] sequence) {
        
        int length = sequence.length;
        
        for (int i = 1; i < length; i++) {
            
            for (int j = 0; j < i; j++) {
                
                if (sequence [i] > sequence [j] && lis[i] <= lis[j]) {
                    lis[i] = lis[j] + 1;
                }
            }
        }
        
        return findLongest(lis, lis.length-1);
    }
    
    public static int findLongest (int [] lis, int index) {
        
        int max = 1;
        
        for (int i = 0; i <= index; i++) {
            if (lis[i] > max) max = lis[i];
        }
        return max;
    }

}
