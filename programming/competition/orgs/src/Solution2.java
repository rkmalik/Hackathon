//package ctci.ch3.probTest;

import java.util.HashMap;
import java.util.Scanner;
import java.util.Stack;

public class Solution2 {
    
    public static void main (String [] args) {
        
    	Scanner in = new Scanner(System.in);
    	String str = in.nextLine();
    	foo1(str);
    }
    
    static void foo1 (String str) {
    	
    	int count = 26;
    	boolean [] b = new boolean [26];
    	
    	
    	char [] arr = str.toCharArray();
    	
    	for (int i = 0; i < arr.length; i++) {
    		
    		if ((arr[i] >= 65 && arr[i] >= 90 ) || (arr[i] >= 97 && arr[i] >= 122)) {
    			
    			if ((arr[i] >= 65 && arr[i] >= 90 ) && b[arr[i]-65] == false) {
    				count --;
    				b[arr[i]-65] = true;
    				
    			}else if ((arr[i] >= 97 && arr[i] >= 122) && b[arr[i]-97] == false) {
    				count --;
    				b[arr[i]-97] = true;
    			}

    			if (count == 0) {
            		System.out.println("pangram");
            	}
    		}
    	}
		System.out.println("not pangram");
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
