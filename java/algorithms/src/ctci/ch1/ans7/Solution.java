package ctci.ch1.ans7;

public class Solution {

	public static void main(String args[]) {

		int[][] a = { 
				{ 1, 2, 3, 4 , 18}, 
				{ 5, 6, 0, 8, 19 }, 
				{ 9, 10, 11, 12, 0 }, 
				{ 13, 0, 15, 16, 21 }, 
				{ 22, 23, 24, 25, 26 } };

		for (int i = 0; i < a.length; i++) {
			System.out.print("{");
			for (int j = 0; j < a[0].length; j++) {
				if (j == a[0].length-1) {
					System.out.printf("%5d",a[i][j]);
					break;
				} else
					System.out.printf("%5d, ", a[i][j]);

			}
			System.out.println("}");
		}
		
		resetRowCol(a);
		System.out.println("\n");
		for (int i = 0; i < a.length; i++) {
			System.out.print("{");
			for (int j = 0; j < a[0].length; j++) {
				if (j == a[0].length-1) {
					System.out.printf("%5d",a[i][j]);
					break;
				} else
					System.out.printf("%5d, ", a[i][j]);

			}
			System.out.println("}");
		}

	}

	public static void resetRowCol(int[][] a) {

		boolean rows [] = new boolean [a.length];
		boolean cols [] = new boolean [a[0].length];
		
		// Find all the columns and rows which has zero
		for (int i = 0; i < a.length; i++) {
			
			for (int j = 0; j < a[0].length; j++) {
				
				if (a[i][j] == 0) {
					rows[i] = true;
					cols[j] = true;
				}
			}
		}
		
		// Reset all the rows 
		for (int i = 0; i < rows.length; i++) {
			if (rows[i] == true) {
				for (int j = 0; j < a[0].length; j++) {
					a[i][j] = 0;
				}
			}
		}
		
		// reset all the columns
		for (int i = 0; i < cols.length; i++) {
			if (cols[i] == true) {
				for (int j = 0; j < a.length; j++) {
					a[j][i] = 0;
				}
			}
		}
		
		
	}

}