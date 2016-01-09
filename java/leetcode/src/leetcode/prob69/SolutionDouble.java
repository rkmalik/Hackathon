package leetcode.prob69;
public class SolutionDouble {

	public static final double EFSILON = .00001;

	public static void main (String args []) {
	
		System.out.println(sqrt(36));
		
	}
	
	
	private static int sqrt (int x) {
		
		double low = 0.0;
		double high = x;
		
		double efsilon = Double.MAX_VALUE;
		double mid  = Double.MAX_VALUE;


		while (true) {
		
			mid = (high+low)/2;
			System.out.println(mid);
			efsilon = Math.abs((mid*mid) - x);
			if (efsilon < EFSILON)
				break;
			if (mid*mid > x) {
				high = mid;
			} else if (mid*mid < x) {
				low = mid;
			} else {
				break;
			}
		}

		System.out.println("Square Root of " + x + " = " + mid);
		return (int)mid;
		
	}
}