package leetcode.prob198;
public class Solution {
    private static int r [] = null;
    public static int rob(int[] nums) {
        r = new int [nums.length];
        
        for (int i = 0; i < nums.length; i++) {
            r[i] = -1;
        }
        
        return rob1 (nums);
    }
    
    private static int rob1 (int [] a) {
        
        if (a.length ==0) return 0;
        if (a.length==1) return a[0];
        
        for (int i = 0; i < a.length; i++) {
            
            if (i==0 || i==1) {
                r[i] = a[i];
                continue;
            }
            
            int max = -1;
            int s1 = i-2<0?0: r[i-2];
            int s2 = i-3<0?0:r[i-3];
            
            r[i] = a[i] + Math.max (s1, s2);
        }
        
        return Math.max (r[r.length-1], r[r.length-2]);
    }
    
    public static void main (String [] args) {
    	
    	int n [] = {2,1,1,2};
    	System.out.println(rob(n));
    	
    }
}