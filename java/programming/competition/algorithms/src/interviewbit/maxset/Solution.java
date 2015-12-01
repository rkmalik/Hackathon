package interviewbit.maxset;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Solution {
    
    public static void main (String args[]) {

        ArrayList<Integer> list = new ArrayList<Integer> ();
        
        //list.add(0);
        
        //list.add(-1);
        
        
        
        list.add(1);
        list.add(2);
        list.add(5);
        
        list.add(-7);
        /*
        list.add(1);
        list.add(1);
        list.add(2);
        list.add(3);*/
        
        
        System.out.println(maxset(list));
    }
    
    
	public static ArrayList<Integer> maxset(ArrayList<Integer> a) {
	    
	    HashMap<Integer, ArrayList<Integer>> map = new HashMap<Integer, ArrayList<Integer>>();
	    int max = -1;
	    int sum = 0;
	    
	    
	    ArrayList<Integer> list = new ArrayList<Integer> ();
	    
	    if (a.size() ==0) return list;
	    
	    for (int j = 0; j < a.size(); j++) {
	        
	        int i = a.get(j);
	        
	        if (i < 0 && list.size() >0) {
	            
	            if (sum > max) {
	                // remove max and insert the new max
	                map.remove(max);
	                map.put(sum, list);
	                max = sum;
	                list = new ArrayList<Integer>();
	                
	            } else if (sum == max) {
	                
	                // remove the older max if current length is more
	                
	                List<Integer> olist = map.get(max);
	                if (list.size() > olist.size()) {
	                    map.put(max, list);
	                    list = new ArrayList<Integer>();
	                }
	            }
	            
	        } else if (i >= 0) {
	            list.add(i);
	            sum += i;
	        }
	    }
	    
	    if (sum > max) return list;
	    
	    
	    return map.get(max);
	}
}
