package leetcode.prob74;
public class Solution {
	
	public static void main (String [] args) {
		
		/*int a [][] = {
			
				{1, 3, 5, 7},
				{10, 11, 16, 20},
				{23, 30, 34, 50}
		};*/
		int a [][] = {
				
				{1},
				{3},
				{5}
		};
		
		System.out.println(searchMatrix(a, 3));
		
		
		
	}
	
    public static boolean searchMatrix(int[][] a, int target) {
        
    	
    	//First find the appropriate row which needs to be searched.
    	int first = 0;
    	int last = a.length-1;
    	int mid = 0;
    	while (last>=first) {
    		
    		mid = first + (last-first)/2;
    		
    		if (a[mid][0] > target) {
    			
    			last = mid-1;
    		} else if (a[mid][a[0].length-1] < target) {
    			first = mid+1;
    		} else if (a[mid][0] <= target && a[mid][a[0].length-1] >= target  ){
    			break;
    		}
    	}

    	int row = mid;
    	first = 0; 
    	last = a[row].length-1;
    	
    	while (last>=first) {
    		
    		mid = first+(last-first)/2;
    		if (a[row][mid] > target)
    			last = mid-1;
    		else if (a[row][mid] < target) {
    			first = mid+1;
    		} else {
    			System.out.println("a["+row+"]"+"["+mid+"]");
    			return true;
    		}
    	}
    	
    	return false;
    }
}