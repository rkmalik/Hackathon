package leetcode.prob34;

public class Solution {

	public static void main(String[] args) {

		int[] nums = {1,2,2};
		
		
		int[] res = { -1, -1 };
		binarySearchRange(nums, 0, nums.length-1, 1, res);
		System.out.println(res[0] + " " + res[1]);
	}

	public static void binarySearchRange(int[] a, int left, int right, int target, int [] res) {

		if (right < left) return;
		
		if (a[left] == a[right] && a[right]  == target) {
			res[0] = left;
			res[1] = right;
			return;
		}
		// Now lets shrink the search window
		int mid = left + (right-left)/2;
		/**
		 * Now there arises 3 condition
		 * 1. mid is less than target
		 * 2. mid is greater than target
		 * 3. mid is same as that of the target
		 * */
		
		if (a[mid] < target) {
			binarySearchRange (a, mid+1, right, target, res);
		} else if (a[mid] > target) {
			binarySearchRange (a, left, mid-1, target, res);
		} else {
			
			// now we are at the range value just need to find the starting point and ending point of the range.
			int s1 = mid;
			int e1 = mid;

			while(true) {
				if(s1==left)
					break;
				if (a[s1-1] == target)
					s1--;
				else 
					break;
			}
			
			
			while (true) {
				if (e1==right)
					break;
				if (a[e1+1] == target)
					e1++;
				else 
					break;
			}
			
			binarySearchRange (a, s1, e1, target, res);
			
		}
	}
}