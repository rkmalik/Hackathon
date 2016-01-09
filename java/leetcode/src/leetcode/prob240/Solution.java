package leetcode.prob240;

public class Solution {

	public static void main(String args[]) {
		
		/*int a [][] = {
				  {1,   4,  7, 11, 15},
				  {2,   5,  8, 12, 19},
				  {3,   6,  9, 16, 22},
				  {10, 13, 14, 17, 24},
				  {18, 21, 23, 26, 30}
				};*/
		int a[][] = {{-1},
				{-1}};
		
		System.out.println(searchMatrix(a, -2));

	}

	public static boolean searchMatrix(int[][] a, int target) {
		
		if (a == null || a.length == 0 || a[0].length == 0)
			return false;

		int stRow = 0;
		int endRow = a.length-1;
		
		// First reach the rows which starts with more than target, 
		// it is sure that we will not find the target in those rows.
		
		// also the rows which ends with less than target
		
		// Find appropriate endRow
		int sr = 0;
		int er = a.length-1;
		int m = 0;
		
		while (true) {
			
			if (sr>er) 
				break;

			m = sr + (er-sr)/2;
			
			if (a[m][0]>target)
				er = m-1;
			else if (a[m][0] < target) 
				sr = m+1;
			else 
				break;
		}
		
		endRow = m;
		sr = 0;
		er = a.length -1;
		
		while (true) {
			
			if (sr>er) 
				break;

			m = sr + (er-sr)/2;
			
			if (a[m][a[0].length-1]>target)
				er = m-1;
			else if (a[m][a[0].length-1] < target) 
				sr = m+1;
			else 
				break;
		}
		
		stRow = m;
		
		
		//System.out.println(stRow + "  " + endRow);
		
		for (int i = stRow; i <= endRow; i++) {

			sr = 0;
			er = a[0].length-1;
			
			while (true) {
				if (er < sr)
					break;
				m = sr + (er-sr)/2;
				
				if (a[i][m]> target)
					er = m-1;
				else if (a[i][m] < target)
					sr = m+1;
				else {
					
					//System.out.println("[" +i+"]" +"[" +m+"]" );
					return true;
				}
			}
			
			
		}
		return false;
	}
}