package leetcode.prob8;

import java.util.ListIterator;
import java.util.Random;

public class Main {
	
	
	public static void main (String args[]) {
		
		Solution sol = new Solution ();
		String str;
		/*String str = "abcabcbb";
		System.out.println("Maximum length for " + str + " : " + sol.lengthOfLongestSubstring(str));*/
		
		//str = "2147483648";
		str ="    10522545459";
		str = "9223372036854775809";
		System.out.println("Maximum length for " + str + " : " + sol.myAtoi(str));
		
		
	}

}
