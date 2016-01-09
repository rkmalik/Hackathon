package leetcode.prob50;

public class Solution {

	public static void main(String[] args) {

		/*System.out.println(" Power " + myPow(8.88023, 3));
		System.out.println(" Power " + myPow(-5, -3));
		System.out.println(" Power " + myPow(0.0004, -3));*/
		//System.out.println(" Power " + myPow(0.0004, 3));
		System.out.println(" Power " + myPow(0.00001, 2147483647));
		System.out.println(myPow(-13.62608,3));

	}

	public static double myPow(double x, int n) {

		double epsilon = .00000001; 
		
		
		if (n == 0)
			return (double) 1;
		if (n == 1)
			return x;
		if (x == 1.0)
			return x;

		int absn = n;

		if (n < 0)
			absn = -1 * n;

		double rx = x;

		while (absn > 1) {
			rx *= x;
			absn--;
			
			if (Math.abs(rx)<epsilon) {
				rx = 0.0;
				break;
			}
			

		}

		if (n < 0) {
			rx = (1 / rx);
		}

		return rx;

	}
}