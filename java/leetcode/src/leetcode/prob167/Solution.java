package leetcode.prob167;

public class Solution {
	
	
	public static void main (String args []) {
		
		int a [] = {2, 3, 5, 9, 12, 26, 46};
		
		int result [] = twoSum (a, 29);
		
		for (int i : result) {
			System.out.print(i + " ");
		}
	}

	public static int[] twoSum(int[] a, int target) {

		int[] result = new int[2];

		int i = 0;
		int j = a.length - 1;

		while (i < j) {

			if (a[j] > target - a[i]) {
				j--;
			} else if (a[i] < target - a[j]) {
				i++;
			} else {
				result[0] = i + 1;
				result[1] = j + 1;
				return result;
			}
		}
		return result;
	}

}