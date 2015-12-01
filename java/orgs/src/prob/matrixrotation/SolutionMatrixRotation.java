package prob.matrixrotation;

public class SolutionMatrixRotation {

	public static void main(String[] args) {

		/*
		 * int a[][] = { {1, 2, 3, 4, 5, 6}, {7, 8, 9, 10, 11, 12}, {13, 14, 15,
		 * 16, 17, 18} };
		 */

		int a[][] = { 
				{ 1, 	2, 		3, 		4 , 	100, 101,}, 
				{ 5, 	6, 		7, 		8, 		102, 103, }, 
				{ 9, 	10, 	11, 	12, 	104, 105, }, 
				{ 13, 	14, 	15, 	16, 	106, 107, },
				{ 17, 	18, 	19, 	20, 	108, 109, },
				{ 21, 	22, 	23, 	24, 	110, 111, }
			};

		
		
		System.out.println("{");
		
		int size = a.length;
		
		for (int i = 0; i < size; i++) {
			System.out.print("{");
			for (int j = 0; j < size; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("}");
		}
		System.out.print("}");

		
		
		matrixRotation(size, a);
		
		
		System.out.println("\n\n{");
		
		for (int i = 0; i < size; i++) {
			System.out.print("{");
			for (int j = 0; j < size; j++) {
				System.out.print(a[i][j] + "\t");
			}
			System.out.println("}");
		}
		System.out.print("}");
	}
	
	public static void matrixRotation (int n, int a[][]) {
		
		int layers = n/2;
		
		for (int layer = 0; layer < n/2; layer++) {
			int first = layer;
			int last = n-1-layer;
			
			for (int i = first; i < last; i++) {
				int offset = i - first;
				
				int top = a[first][i];
				a[first][i] = a[last-offset][first];
				a[last-offset][first]= a[last][last-offset];
				
				a[last][last-offset] = a[i][last];
				
				a[i][last] = top;
			}
		}
	}
}
