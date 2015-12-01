//package ctci.ch3.probTest;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution1 {
    
    public static void main (String [] args) {
        
    	Scanner in = new Scanner(System.in);
    	
    	int T = 0;
    	T = Integer.parseInt(in.nextLine());
    	
    	ArrayList<ArrayList<Integer>> arr = new ArrayList<ArrayList<Integer>> ();
    	ArrayList<Integer> arrk = new ArrayList<Integer>();
        
        for(int i = 0; i < T; i++) {
        	
        	int N = Integer.parseInt(in.next());
        	int K = Integer.parseInt(in.next());
        	arrk.add(K);
        	ArrayList<Integer> arr1 = new ArrayList<Integer> ();
        	
        	for (int j = 0; j < N; j++) {
        		arr1.add(Integer.parseInt(in.next()));
        	}
        	
        	arr.add(arr1);
        }
        
        
        for(int i = 0; i < T; i++) {
        	foo1(arr.get(i), arrk.get(i));
        }
    	
    }
    
    static void foo1 (ArrayList<Integer> arr, int k) {
    	
    	int count = 0;
    	
    	for (int i = 0; i < arr.size(); i++) {
    		
    		if (arr.get(i) <= 0)
    			count++;
    		
    	}
    	if (count >= k)
    	System.out.println("NO");
    	else 
    		System.out.println("YES");
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
                	/*} else if (map.get(r) != null) {
                		int digit =  map.get(r);
                		map.put(r, digit+1);
                	}*/
                }
            }
            
            System.out.println(count);
            
        }
    }
}
