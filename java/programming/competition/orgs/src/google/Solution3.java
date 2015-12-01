package google;

public class Solution3 {
	
	public static void main (String [] args) {
		
		multiTable (12);
		
		
	}
	
	static void multiTable (int m) {
		
		
		for (int i = 1; i <= 10; i++) {
			
			for (int j = 1; j<=m; j++) {
				
				int num = j*i;
				
				System.out.print(String.format("%4d  | ", num));
			}
			System.out.println("");
		}
		String str = "______________________________________________";
		System.out.println(str+str+str);
	}
}
