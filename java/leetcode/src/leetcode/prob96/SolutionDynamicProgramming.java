package leetcode.prob96;

public class SolutionDynamicProgramming {

	public static void main(String[] args) {

		System.out.println(numTrees(19));
	}

	private static int a[] = null;

	public static int numTrees(int n) {
		a = new int[n + 1];
		
		for (int i = 1; i <= n; i++) {
			
			if (i==0 || i ==1) {
				a[0] = 1;
				a[1] = 1;
				continue;
			} 
			
			int res = 0;

			int last = i-1;
			for (int j = 0; j <= last; j++) {
				res+= a[j]*a[last-j];
			}
			a[i] = res;
		}
		
		return a[n];
	}

	/*public static int nTrees(int n) {

		

	}*/
}