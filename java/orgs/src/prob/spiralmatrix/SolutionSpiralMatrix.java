package prob.spiralmatrix;

public class SolutionSpiralMatrix {
	static int R = 3;
	static int C = 6;

	static void matSpatialPrint(int rows, int cols, int matrix[][]) {

		int i = 0;
		int startingRowIndex = 0;
		int startingColIndex = 0;

		while (startingRowIndex < rows && startingColIndex < cols) {

			for (i = startingColIndex; i < cols; i++) {
				System.out.print(" " + matrix[startingRowIndex][i]);
			}
			startingRowIndex++;

			for (i = startingRowIndex; i < rows; i++) {
				System.out.print(" " + matrix[i][cols - 1]);
			}
			cols--;

			if (startingRowIndex < rows) {

				for (i = cols - 1; i >= startingColIndex; i--) {
					System.out.print(" " + matrix[rows - 1][i]);
				}
				rows--;
			}

			if (startingColIndex < cols) {

				for (i = rows - 1; i >= startingRowIndex; i--) {
					System.out.print(" " + matrix[i][startingColIndex]);
				}
				startingColIndex++;
			}
		}
	}

	static void spiralprint(int rows, int cols, int matrix[][]) {
		int i, startingRowIndx = 0, startColIndx = 0;

		/*
		 * k - starting row index m - ending row index l - starting column index
		 * n - ending column index i - iterator
		 */

		while (startingRowIndx < rows && startColIndx < cols) {
			/* Print the first row from the remaining rows */
			for (i = startColIndx; i < cols; ++i) {
				System.out.print("  " + matrix[startingRowIndx][i]);
			}
			startingRowIndx++;

			for (i = startingRowIndx; i < rows; ++i) {
				System.out.print("  " + matrix[i][cols - 1]);
			}
			cols--;

			if (startingRowIndx < rows) {
				for (i = cols - 1; i >= startColIndx; --i) {

					System.out.print("  " + matrix[rows - 1][i]);
				}
				rows--;
			}

			if (startColIndx < cols) {
				for (i = rows - 1; i >= startingRowIndx; --i) {
					System.out.print("  " + matrix[i][startColIndx]);
				}
				startColIndx++;
			}
		}
	}

	public static void main(String[] args) {

		/*
		 * int a[][] = { {1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15,
		 * 16, 17, 18} };
		 */

		int a[][] = { { 1, 2, 3, 4 }, { 5, 6, 7, 8 }, { 9, 10, 11, 12 }, { 13, 14, 15, 16 } };

		matSpatialPrint(4, 4, a);
	}

}
