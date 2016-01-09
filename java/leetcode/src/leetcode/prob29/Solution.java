package leetcode.prob29;

public class Solution {
	
	
	public static void main (String args []) {
		
		int num = 2147483647;
		
		System.out.println(divide (-1010369383, -2147483648));
		System.out.println(divide (2, 2));
		System.out.println(divide (-44, -12));
		
	}
	
	public static int divide(int divd, int divis) {
		
		long dividend = divd;
		long divisor = divis;

		if (divisor == 0)
			return Integer.MAX_VALUE;
		
		if (divisor == -1 && dividend == Integer.MIN_VALUE)
			return Integer.MAX_VALUE;
		
		int sign = 1;

		if (dividend < 0) {
			dividend = Math.abs(dividend);
			sign = -sign;
		}

		if (divisor < 0) {
			divisor = Math.abs(divisor);
			sign = -sign;
		}
		
		int result = 0;
		long nDivisor = divisor;
		long nDividend = dividend;

		while (nDividend > nDivisor) {
			int shift = 0;
			while ((nDivisor << shift) < nDividend)
				shift++;

			result += 1 << (shift - 1);

			nDividend = (nDividend) - (nDivisor << (shift - 1));
		}
		
		if (nDividend == nDivisor)
			result+=1;
		
		return (sign)*result;
	}
}