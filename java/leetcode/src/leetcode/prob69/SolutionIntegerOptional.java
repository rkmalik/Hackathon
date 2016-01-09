package leetcode.prob69;
public class SolutionIntegerOptional {

	public static final double EFSILON = .00001;

	public static void main (String args []) {
	
		int x = 2147395599;
		long l = 0;
		long h = x;
		
		long mid = Integer.MAX_VALUE;
		long sqr = 0;
		
		while (h-l > 1) {
			mid = (h+l)/2;
			sqr = mid*mid;
			if (sqr > x) {
				h = mid;
			} else {
				l = mid;
			} 
		}

		System.out.println("Square Root of " + x + " = " + (h+l)/2);
	}
}