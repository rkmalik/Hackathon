package leetcode.prob88;

public class Solution {
	public void merge(int a[], int n, int b[], int m) {

		int i = n - 1;
		int j = m - 1;
		int cur = m + n - 1;

		while (cur >= 0) {

			if (i >= 0 && j >= 0) {
				a[cur] = (a[i] > b[j]) ? a[i--] : b[j--];
			} else if (i >= 0) {
				a[cur] = a[i--];
			} else {
				a[cur] = b[j--];
			}
			cur--;
		}
	}
}