package ctci.ch17.prob1;

import java.util.Scanner;

public class Solution {
    
    public static void main (String [] args) {

        Scanner sc = new Scanner(System.in);
        System.out.print("Enter value of a = " );
        Integer a = sc.nextInt();
        System.out.print("Enter value of b = " );
        Integer b = sc.nextInt();

        
        System.out.println("a = " + a + " b = " + b);
        a = a + b;
        b = a - b;
        a = a - b;
        System.out.println("a = " + a + " b = " + b);
    }
}
