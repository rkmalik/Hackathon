package ctci.ch18.prob1;

import java.util.Scanner;

public class Solution {
    
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the number = " );
        int num = sc.nextInt();
        System.out.print("Enter which digit to find (0-9) = " );
        int b = sc.nextInt();

        int length = String.valueOf(num).length();
        int count = 0;
        
        for (int i = 0; i < length; i++) {
            count += findNumberofDigits(num, i, b);
        }
        
        System.out.println("Total number of " + b + "s in number " + num + " = " + count);
    }
    
    public static int findNumberofDigits (int num, int place, int whichDigit) {
        
        int powerOf10 = (int)Math.pow(10, place);
        int digit = num / powerOf10;
        digit = digit % 10;
        int count = 0;

        int roundDown = num/(powerOf10*10);
        roundDown = roundDown * (powerOf10*10);
        
        // Case 1: 
        if ( digit  < 2) {
            
            // Round down to the ten's multiple
            count = roundDown / 10;
            
        } else if (digit > 2) {
            
            count = roundDown / 10;
            
        } else {
            count = roundDown / 10;
            count += (num%powerOf10) + 1; 
        }
        
        return count;
    }
}
