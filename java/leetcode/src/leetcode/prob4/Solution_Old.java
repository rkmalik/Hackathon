package leetcode.prob4;
public class Solution_Old {
	
public static void main (String args[]) {
		
		
		int n1 [] = {3,3,5,9,11};
		int n2 [] = {3,5,7,9} ;
		System.out.println(findMedianSortedArrays(n1, n2));
	}
	
    public static double findMedianSortedArrays(int[] nums1, int[] nums2) {
        return medianFind(nums1, 0, nums1.length-1, nums2, 0, nums2.length-1);
    	     
    }
    
    private static double medianFind (int [] arr1, int s1, int e1, int [] arr2, int s2, int e2) {
    	
    	
    	/*
    	 * 1. find the median of two array 
    	 * 2. compare the two medians
    	 * 3. consolidate in the problem set. 
    	 * 4. Stop criteria is if both the left part and rgith part is 2 or in total 5.
    	 * 5. if it is 5 then find the first of the the bigger array as median
    	 * 6. if the size is 2 then find the median = (max (n1[s1], n2[s2]) + min (n1[e1] + n2[e2])/2))
    	 * that will be the median.  
    	 * */
    	int size1 = e1-s1+1;
    	int size2 = e2-s2+1;
    	int total = size1+size2;
    	
    	if (total==4) {
    		double median = (Math.max(arr1[s1], arr2[s2]) + Math.max(arr1[e1], arr2[e2]))/2;
    		return median;
    		
    	} else if (total ==5) {
    		if (size1 > size2) {
    			return arr1[s1];
    		}
    		return arr2[s2];
    	}
    	

    	// Find median1 and median2
    	double m1;
    	double m2;

    	int mid1 = s1+size1/2;
    	
    	// if size is odd then find the middle one
    	if (size1%2 == 0) {
    		m1 = arr1[mid1];
    	} else {
    		m1 = (arr1[mid1] + arr1[mid1])/2;
    	}
    	
    	int mid2 = s2+size2/2;
    	// if size is odd then find the middle one
    	if (size2%2 == 0) {
    		m1 = arr2[mid2];
    	} else {
    		m1 = (arr2[mid2] + arr1[mid2-1])/2;
    	}
    	
    	
    	
    	
    	return 0.0;
        
    }
    
}