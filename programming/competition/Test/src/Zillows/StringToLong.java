package Zillows;
public class StringToLong {

	public static void main(String[] args) {
		long l = parseLong("0");
		System.out.println(l);
		if (l == 0L) {
			System.out.println("Success...");
		} else {
			System.out.println("Failure");
		}
	}

	private static long parseLong(String str) {
		if (str.isEmpty())
			return 0;
		
		boolean signed = str.startsWith("-") || str.startsWith("+");
		boolean neg = str.startsWith("-");
		int begin = signed ? 1 : 0;
		int last = str.length();
		
		long result = 0;
		
		for (int i = begin; i < last; i++) {
			char c = str.charAt(i);
			
			if (c < '0' || c > '9') {
				throw new IllegalArgumentException("Invalid format");
			}
			
			result = result * 10 + Character.digit(c, 10);
		}
		
		return neg ? -result : result;
	}

}