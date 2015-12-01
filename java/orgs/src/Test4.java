
public class Test4 {
	
static String[] ReduceFraction(String[] fractions) {
        
        
        for (int i = 0; i < fractions.length; i++) {
        	
        	fractions[i] = reduceFraction (fractions[i]); 
        }
        
        return fractions;
    }
	
	
	static String reduceFraction(String str) { 
		String [] num = str.split("/");
		
		int numerator = Integer.parseInt(num[0]);
		int denominator = Integer.parseInt(num[1]);
	    int n = numerator; 
	int d = denominator; 

	while (d != 0) { 
	int t = d; 
	d = n % d; 
	n = t; 
	} 

	int gcd = n; 

	
	numerator /= gcd; 
	denominator /= gcd;     
	    
	String result = String.valueOf(numerator) + "/" + String.valueOf(denominator);
	
	return result;
	
	} 

}
