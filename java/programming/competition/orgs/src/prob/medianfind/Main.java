package prob.medianfind;

public class Main {
	
	private static SolutionMedianFind sol;
	
	public static void main (String args []) {
		
		int size = 21;
		SolutionMedianFind sol = new SolutionMedianFind(size);
		
		
		for(int i = 0; i < size; i++) {
            int random= (int) (Math.random( ) * (9+1));
            sol.insertRandomWrapper(random);
		}
		
		
	}

}
