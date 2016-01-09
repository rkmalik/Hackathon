package leetcode.prob16;

import java.util.ArrayList;
import java.util.List;
import java.util.ListIterator;
import java.util.Random;

public class Main {
	
	
	public static void main (String args[]) {
		
		Solution sol = new Solution ();
		int [] arr = {-1, 0, 1, -1, 2, -1, -4};
		//int [] arr = {-1, 1, 0};
		
		List<List<Integer>> list = sol.threeSum(arr);
		
		System.out.println(list);
	}

}
