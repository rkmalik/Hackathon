package leetcode.prob49;

import java.util.Arrays;
import java.util.Comparator;

public class SolutionWithComparator {

	public static class AnagramComparator implements Comparator<String> {

		private String getString(String str) {
			char[] arr = str.toCharArray();
			Arrays.sort(arr);
			return new String(arr);
		}

		public int compare(String o1, String o2) {
			return getString(o1).compareTo(getString(o2));
		}
	}

	public static void groupAnagrams(String[] strs) {
		Arrays.sort(strs,new AnagramComparator());
		
		for (String s : strs) {
			System.out.println(s);
		}
	}

	public static void main (String args []) {
		
		String [] strings = {
				"eat", "tea", "tan", "ate", "nat", "bat"
		};
		
		groupAnagrams(strings);
	}
	
}
