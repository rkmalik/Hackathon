package leetcode.prob4;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return medianFind(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
    	     
    }
    
    private double medianFind (int [] n1, int s1, int e1, int [] n2, int s2, int e2) {
        
        if (e1 == s1 + 1 && e2 == s2 + 1) {
            return ((Math.max(n1[0], n2[0]) + Math.min(n1[1], n2[1])) / 2);
        }

        int l1 = e1-s1+1;
        int l2 = e2-s2+1;
        
        
        int med1 = (l1)%2==0 ?((n1[s1+ l1/2] + n1[s1+ (l1-1)/2])  /2) : n1[(s1+l1)/2];
        int med2 = (l2)%2==0 ?((n2[s2+ l2/2] + n2[s2+ (l2-1)/2])  /2) : n2[(s2+l2)/2];
        
        if (med1 == med2) {
            return med1;
        } else  if (med1 < med2) {
            return medianFind(n1, s1+l1/2, e1, n2, s2, s2+(l2-1)/2);
        } else {
            return medianFind(n1, s1, s1+l1/2, n2, s2+(l2-1)/2, e2);
        }
    }
    
}