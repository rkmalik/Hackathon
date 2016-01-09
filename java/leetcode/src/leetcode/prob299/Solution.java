package leetcode.prob299;

import java.util.HashMap;
import java.util.HashSet;

public class Solution {
	
	public static void main (String args []) {
		
		String secret = "1123";
		String guess = "0111";
		
		System.out.println(getHint(secret, guess));
		
	}
	
		
    public static String getHint(String secret, String guess) {
        HashSet<Integer> bulls = new HashSet<> ();
        HashSet<Integer> cows = new HashSet<> ();

		char secretChars [] = secret.toCharArray();
		char guessChars [] = guess.toCharArray();


		// First process the bulls
		for (int i = 0; i < secretChars.length; i++) {
			if (secretChars[i] == guessChars[i])
				bulls.add (i);
		}
        
		for (int i = 0; i < secretChars.length; i++) {

			if (bulls.contains(i))
				continue;
			
			for (int j = 0; j < guessChars.length; j++) {
				
				if (cows.contains(j) || bulls.contains(j))
					continue;
			    
				if (secretChars[i] == guessChars[j] && !bulls.contains(j)) {
						cows.add(j);
						break;
				}				
			}
		}

		String result = bulls.size () + "A"+ cows.size() + "B";
		return result;
    }
}