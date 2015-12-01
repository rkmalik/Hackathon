package leetcode.prob16;

import java.util.ArrayList;
import java.util.List;

public class Solution {
        public List<List<Integer>> threeSum(int[] nums) {
            
            List<List<Integer>> list = new ArrayList<List<Integer>> ();
            
            for (int i = 0; i < nums.length; i++) {
                
                if (i+2 < nums.length && (nums[i]+ nums[i+1]+ nums[i+2]) == 0) {
                    
                    List<Integer> numList = new ArrayList<Integer>();
                    numList.add(nums[i]);
                    numList.add(nums[i+1]);
                    numList.add(nums[i+2]);
                    list.add(numList);
                }
                
            }
            return list;
        }
}