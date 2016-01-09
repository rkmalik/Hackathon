package leetcode.prob69;
public class SolutionInteger {

	public static final double EFSILON = .00001;

	public static void main (String args []) {
	
		int x = 44;
		int low = 0;
		int high = x;
		
		int mid = Integer.MAX_VALUE;
		
		while (true) {
		
			mid = (high-low)/2;
			System.out.println(mid);
			if (mid*mid > x) {
				high = mid;
			} else if (mid*mid < x) {
				low = mid;
			} else {
				break;
			}
		}

		System.out.println("Square Root of " + x + " = " + mid);
	}
}