package ctci.ch17.prob4;

import java.util.Scanner;

/**
 * This code provides the solution to find the maximum of two numbers 
 * without using if-else statement. 
 * 
 * */
public class Solution {
    
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of a = " );
        Integer a = sc.nextInt();
        System.out.print("Enter value of b = " );
        Integer b = sc.nextInt();

        System.out.println("Max number is = " + findMax (a, b));
        
    }
    
    public static int findMax (int a, int b) {
        
        int s1 = getSign (a-b);
        int s2 = flip (s1);
        int result = a*s1 + b * s2;
        
        
        return result;
    }
    
    public static int getSign (int a) {
        
        // get the left most bit by shifting the number by 31 places which specifies the sign bit
        int num = a >> 31;  
        
        //  if this is a negative number then it will be 1, so make it zero, we just simply flip the bit 
        int result = num & 0x1;
        
        
        result = flip (result);
        
        //result = flip (a >> 31 & 0x1);
        
        return result; 
    }
    
    public static int flip (int bit) {
        int a = 1^bit;
        return a;
    }
    
}
