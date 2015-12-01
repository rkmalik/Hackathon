package prob1;

import java.util.HashMap;
import java.util.Hashtable;

public class A1TwoSum {
	
	// No need to maintain the state
	public int[] twoSum(int[] nums, int target) {
		
		int [] output = {0,0};
		int size = nums.length;
		
		int i;
		int first;
		int second;
		
		
		HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
		
		for (i = 0; i < size; i++ ) {		
			first = nums[i];
			second = target - first;
			
			if (map.get(second) != null) {
				output[0] = map.get(second)+1;
				output[1] = i+1;
				break;
			}
			
			map.put(first, i);
		}
		
		return output;
    }

}
