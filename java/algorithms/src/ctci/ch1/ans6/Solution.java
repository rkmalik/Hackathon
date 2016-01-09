package ctci.ch1.ans6;

public class Solution {

	public static void main(String args[]) {

		int[][] a = { { 1, 2, 3, 4 , 18}, { 5, 6, 7, 8, 19 }, { 9, 10, 11, 12, 20 }, { 13, 14, 15, 16, 21 }, { 22, 23, 24, 25, 26 } };

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
		
		rotateMatrix(a);
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

	public static void rotateMatrix(int[][] a) {
		int levels = (a[0].length)/2;
		int length = (a[0].length-1);
		
		for (int l = 0; l < levels; l++) {
			
			int offset = l;
			
			for (int i = offset; i < length-offset; i++) {
				
				int temp = a[offset][i];
				a[offset][i] = a[length-i][offset];
				a[length-i][offset] = a[length-offset][length-i];
				a[length-offset][length-i] = a[i][length-offset];
				a[i][length-offset] = temp;
			}
		}
	}

}