package leetcode.prob126;
public class Solution {
    static public int searchInsert(int[] nums, int target) {
        
        if (nums.length ==0) return 0;
        
        return findTarget(nums, 0, nums.length-1, target);
        
    }
    
    static private int findTarget(int [] a, int s, int e, int t) {
        
        int m = s+ (e-s)/2;
        
        if (e == s) return s;
        
        if (a[m] > t) {
            findTarget(a, s, m-1, t);
        } else if (a[m] < t) {
            findTarget(a, m+1, e, t);
            
        }
        
        return m;
    }
    
    public static void main (String args[]) {
        
        int nums [] = {1,3};
        
        searchInsert(nums, 0);
        
    }
}