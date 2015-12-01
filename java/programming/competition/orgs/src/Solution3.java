/*//package ctci.ch3.probTest;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution3 {
	
	int factoria[];
    
    public static void main (String [] args) {
        
    	Scanner in = new Scanner(System.in);
    	
    	int size = 0;
    	size = Integer.parseInt(in.nextLine());
        
        int[] arr = new int[size];
        int item;
        for(int i = 0; i < size; i++) {
            item = Integer.parseInt(in.nextLine());
            arr[i] = item;
        }

        for(int i = 0; i < size; i++) {
            item = Integer.parseInt(in.next());
            arr[i] = item;
        }
        
    	//foo1(arr);
    	
    	for (int i = 0; i < arr.length; i++) {
    		System.out.print(arr[i] + " ");
    	}

    	int n = 4;
    			
    	factorialRemainder(n);
    	
    	
    	int count = Integer.parseInt(stdin.next());
    	int arr [] = new int [count];
        
    	for (int i = 0; i < count; i++) {
    		arr [i] = Integer.parseInt(stdin.next());
    	}
    	
    }
    
    static int factorialRemainder (int n) {
    	
    	int count = 0;
    	BigInteger f = BigInteger.ONE;
    	BigInteger last = BigInteger.ONE;
    	
    	for(int i = 1; i <= n; i++) {
    		
    		f = f.multiply(i);
    		
    		int rem = (last.intValue()) % i;
    		
    		if (rem == i-1)
    			count ++;
    		
    		last = f;
    	}

    	System.out.println(count);
    	return count;
    }
    
    static int fact (int n) {
    	
    	if (n == 0 || n == 1)
    		return 1;
    	
    	int f = 1;
    	
    	for (int i = 2; i <= n; i++) {
    		f = f*i;
    	}
    	
    	return f;
    }
    
    
    static void foo(int[] foo) {
    	
    	if (foo.length == 0) {
    		System.out.println(0);
    		return;
    	}
        
        for (int i = 0; i < foo.length; i++) {
            
            int data = foo[i];
            int count = 0;
            int q = data;
            int r = 0;
            int l = String.valueOf(data).length();
            int pd;
            
            
            for (int j = 1; j <= l; j++) {
                r = q % 10;
                q = q / 10;
                
                if (r != 0 && data%r ==  0) {
                	
                	//if (map.get(r) == null) {
                		count++;
                		//map.put(r, 1);
                	} else if (map.get(r) != null) {
                		int digit =  map.get(r);
                		map.put(r, digit+1);
                	}
                }
            }
            
            System.out.println(count);
            
        }
    }
}
*/