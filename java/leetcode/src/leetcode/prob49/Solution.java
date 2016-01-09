package leetcode.prob49;

import java.util.List;
import java.util.LinkedList;
import java.nio.file.attribute.GroupPrincipal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;


public class Solution {
	
	public static void main (String [] args) {
		
		String [] strings = {
				"eat", "tea", "tan", "ate", "nat", "bat"
		};
		
		List<List<String>> list = groupAnagrams (strings);
		
		for (List<String> l : list) {
			for (String s : l) {
				System.out.print(s + " ");
			}
			System.out.println();
		}
	}
	
	public static List<List<String>> groupAnagrams(String[] strs) {

		if (strs == null || strs.length == 0)
			return null;

		LinkedList<List<String>> list = new LinkedList<List<String>>();
		HashMap<String, Integer> listIndex = new HashMap<String, Integer>();

		for (String s : strs) {

			char[] arr = s.toCharArray();
			Arrays.sort(arr);
			String sortedS = String.valueOf(arr);

			// System.out.println(sortedS);

			if (listIndex.containsKey(sortedS)) {

				int index = listIndex.get(sortedS);
				// loop to find the correct position of the string.
				int i = 0;
				List<String> curlist = list.get(index);
				while (i < curlist.size() && curlist.get(i).compareTo(s) < 0) {
					i++;
				}

				curlist.add(i, s);

			} else {

				LinkedList<String> newList = new LinkedList<String>();
				list.add(newList);
				newList.add(s);
				listIndex.put(sortedS, list.size() - 1);
			}
		}

		return list;
    }
}