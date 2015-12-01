package leetcode.prob72;

import java.util.Scanner;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class EditDistance {

    private static int[] fib;

    public static void main(
            String[] args) {
        
        String from = "zeil";
        String to = "trials";
        
        System.out.println(findEditDistnace(from, to));

    }

    public static int findEditDistnace (String from, String to) {

        int row = from.length();
        int col = to.length();
        
        // allocate an array to solve this based on dynamic programming
        int arr[][] = new int [row+1][col+1];
        
        // Initialize the rows and columns
        for (int i = 0; i <= col; i++) {
            arr[0][i] = i;
        }
        
        for (int i = 0; i <= row; i++) {
            arr[i][0] = i;
        }
        
        for (int i = 1; i <= row; i++) {
            
            for (int j = 1; j<= col; j++) {
                if (from.charAt(i-1) == to.charAt(j-1)) {
                    //diag = arr[i-1][j-1];
                    arr[i][j]= arr[i-1][j-1];
                } else {
                    int min = arr[i-1][j-1];
                    
                    if (arr[i-1][j] < min) {
                        min = arr[i-1][j]; 
                    }
                    
                    if (arr[i][j-1] < min) {
                        min = arr[i][j-1] ;
                    }
                    arr[i][j]  = min +1;
                }
                
            }
        }
        
        return arr[row][col];
    }

}
