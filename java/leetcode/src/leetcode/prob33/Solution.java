package leetcode.prob33;

public class Solution {
	public static int search(int[] nums, int target) {
		return searchHelper(nums, target, 0, nums.length - 1);
	}

	private static int searchHelper(int[] a, int t, int l, int h) {

		if (l > h)
			return -1;

		int m = (l + h) / 2;


		// Check which part we need to search
		if (a[m] == t) {
			return m;
		}

		int indx = -1;
		if (a[m]>=a[l]) {

			if (t < a[m] && t >= a[l]) {
				indx = searchHelper(a, t, l, m - 1);
			} else {
				indx = searchHelper(a, t, m + 1, h);
			}

		} else {

			// check which part we need to search
			if (t > a[m] && t <= a[h]) {
				indx = searchHelper(a, t, m + 1, h);
			} else {
				indx = searchHelper(a, t, l, m - 1);
			}
		}

		return indx;
	}
	
	public static void main (String args []) {
		
		int a [] = {3,1};
		int target = 1;
		
		System.out.println(search (a, target));
		
	}
}