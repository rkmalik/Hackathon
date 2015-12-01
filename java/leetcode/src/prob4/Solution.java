package prob4;
public class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
    	
    	int s1, s2, e1, e2;
    	
    	s2 = s1 = 0;
    	e1 = nums1.length -1;
    	e2 = nums2.length -1;
    	
    	int size1 = nums1.length;
    	int size2 = nums2.length;
    	
    	int m1;
    	int m2; 
    	
    	while (size1 > 2 || size2 > 2) {
    		
    		// Find the median and update the start and end points
    		if ((e1 - s1 + 1) / 2 == 0) {
    			
    		}
    	}
    	return 0.0;        
    }
    
}