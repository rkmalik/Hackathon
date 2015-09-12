package ctci.ch18.prob4;

import java.util.Scanner;

public class Solution {
    
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of a = " );
        Integer a = sc.nextInt();
        System.out.print("Enter value of b = " );
        Integer b = sc.nextInt();

        int result = sumWithoutPlusOperator (a, b);
        
        System.out.println("Sum of " + a + " and " + b + " = " + result);
    }
    
    public static int sumWithoutPlusOperator (int a, int b) {
        
        if (b==0) return a;
        
        int sum = a^b;
        int s = a&b;
        int carry = (a&b) << 1;
        
        return sumWithoutPlusOperator(sum, carry);
    }
}
