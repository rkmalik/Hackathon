package leetcode.prob300;

public class Solution {

	private static int[] r = null;

	public static int lengthOfLIS(int[] nums) {

		if (nums.length == 0)
			return 0;

		r = new int[nums.length];

		for (int i = 0; i < nums.length; i++) {
			r[i] = 1;
		}

		return lengthOfLISH(nums, nums.length - 1);
	}

	private static int lengthOfLISH(int[] a, int index) {

		if (index == 0)
			return 1;

		for (int i = 1; i < a.length; i++) {

			for (int j = i - 1; j >= 0; j--) {

				if (a[i] > a[j]) {
					r[i] = r[j] + 1;
					break;
				}
			}
		}

		int max = 0;
		for (int i = a.length - 1; i >= 0; i--) {
			max = max < r[i] ? r[i] : max;
		}

		return max;
	}

	public static void main(String args[]) {
		int a[] = { 1, 3, 6, 7, 9, 4, 10, 5, 6 };
		int b[] = { 10, 9, 2, 5, 3, 7, 101, 18 };
		
		System.out.println(lengthOfLIS(a));
		System.out.println(lengthOfLIS(b));
		
	}
}