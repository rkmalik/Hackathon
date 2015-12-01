package ctci.ch3.probTest;

import java.util.Scanner;
import java.util.Stack;

public class Solution {
    
    public static void main (String [] args) {
        
        Stack<Integer> s = new Stack<Integer> ();
        
        s.push(1);
        s.push(3);
        s.push(8);
        s.push(12);
        s.push(7);
        s.push(10);
        
        
        //s = sortStack(s); 

    }
    
    static void findingDigits(int[] foo) {
        
        for (int i = 0; i < foo.length; i++) {
            
            int data = foo[i];
            int count = 0;
            int q = data;
            int r = 0;
            int l = String.valueOf(data).length();
            int pd;
            
            for (int j = 1; i <= l; i++) {
                pd = r;
                r = q % 10;
                q = q / 10;
                
                if (r != 0 && data%r ==  0)
                    count++;
                if (pd == r)
                    count++;
            }
            
            System.out.println(count);
            
        }
    }
}
