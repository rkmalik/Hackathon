package collection;

import java.math.BigInteger;

public class TestBigInteger {

	public static void main(String args[]) {
		BigInteger fact = factorial(50);
		System.out.println(fact);

	}

	public static BigInteger factorial(int num) {
		
		BigInteger res = BigInteger.ONE;
		for (int i = 1; i <= num; i++) {
			res = res.multiply(new BigInteger(String.valueOf(i)));
		}
		
		return res;
	}
}