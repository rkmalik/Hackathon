package leetcode.prob3;

import java.util.ListIterator;
import java.util.Random;

public class Main {
	
	
	public static void main (String args[]) {
		
		Solution sol = new Solution ();
		String str;
		/*String str = "abcabcbb";
		System.out.println("Maximum length for " + str + " : " + sol.lengthOfLongestSubstring(str));*/
		
		str = "pqrststrabcdstring";
		System.out.println("Maximum length for " + str + " : " + sol.lengthOfLongestSubstring(str));
		
		
	}

}
