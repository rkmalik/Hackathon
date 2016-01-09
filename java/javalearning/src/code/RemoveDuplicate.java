package code;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Random;

public class RemoveDuplicate {
	private static void removeDuplicates(ArrayList <Integer> list) {
		if (list==null || list.size()==0) {
			return;
		}
		HashSet<Integer> itemset = new HashSet<Integer> ();
		for (int i = 0; i < list.size(); ) {
			boolean isPresent = itemset.contains(list.get(i));
			if (isPresent == false) {
				itemset.add(list.get(i));
				i++;
			} else {
				list.remove(i);
			}
		}
	}
	
	private static void reverseList (ArrayList<Integer> list) {


		int size = list.size ();
		int last = size-1;
		
		
		for (int i = 0; i < size/2; i++) {
			int left = list.get (i);
			list.set(i, list.get(last-i)); 
			list.set(last-i, left);
		}
	}	
	public static void main (String args []) {
		
		ArrayList <Integer> list = new ArrayList<Integer>();
		// Allocate a random variable 
		Random rand = new Random();
		
		for (int i = 0; i < 18; i++) {
			list.add(rand.nextInt(15));
		}

		System.out.println (list);
		// Remove all the elements in the
		//removeDuplicates (list);
		reverseList(list);
		System.out.println (list);
		
	}

}
