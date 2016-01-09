package leetcode.prob15;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        
             List<List<Integer>> list = new ArrayList<List<Integer>> ();
             if (nums.length<3)
                return list;
                
            Arrays.sort(nums);
            System.out.println(nums);
            
            for (int i = 0; i < nums.length-2; i++) {
                
                if (i ==0 || nums [i] > nums [i-1]) {
                    
                    int start = i+1;
                    int end = nums.length-1;
                    int negate = -nums[i];
                    
                    while (start < end) {
                        
                      if (nums[start]+ nums[end] == negate) {
                          
                           List<Integer> numList = new ArrayList<Integer>();
                            numList.add(nums[i]);
                            numList.add(nums[start]);
                            numList.add(nums[end]);
                            list.add(numList);
                            end--;
                            start++;
                            
                            while (start < end && nums[end] == nums [end+1])
                                end --;
                            while (start < end && nums[start] == nums [start-1])
                                start++;
                      } else if (nums[start]+ nums[end] > negate) {
                          end --;
                      } else {
                          start ++;
                      }
                    }
                }

            }
            return list;
    }
}