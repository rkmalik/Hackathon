package google;

public class Solution5 {
	
	public static void main (String [] args) {
		
		int r = 255;
		int g = 0;
		int b = 128;
		
		System.out.println(String.format("%02x%02x%02x", r, g, b));
		
		System.out.println((toHex(r) + toHex(g) + toHex(b)).toUpperCase()); 
		
	}
	
	public static String toHex(int c) {
		
		String s =  Integer.toHexString(c);
		return (s.length() == 1) ? "0" + s : s;
	}
	
	
}
