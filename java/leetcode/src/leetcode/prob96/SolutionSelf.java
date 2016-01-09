package leetcode.prob96;

public class SolutionSelf {

	public static void main(String[] args) {

		System.out.println(numTrees(19));
	}

	private static int a[] = null;

	public static int numTrees(int n) {
		a = new int[n + 1];
		return nTrees(n);
	}

	public static int nTrees(int n) {

		if (a[n] != 0)
			return a[n];

		if (n <= 1) {
			a[n] = 1;
			return a[n];
		} else {
			int leftRes;
			int rightRes;
			int res = 0;
			for (int i = 1; i <= n; i++) {
				int left = nTrees(i - 1);
				int right = nTrees(n - i);
				res += left * right;
			}

			a[n] = res;
			return res;
		}

	}
}