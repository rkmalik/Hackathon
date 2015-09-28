import java.util.ArrayList;

public class Test1 {
	
	public static void main (String [] args) {
		
		ArrayList<String> list = new ArrayList<String> ();
		
		//{a, ba, bca, bda, bdca}
		list.add("a");
		list.add("ba");
		list.add("bca");
		list.add("bda");
		list.add("bdca");
		
		ArrayList<String> llist= longestChain(list);
		
		System.out.println();
		
	}
	
	private static ArrayList<String> longestChain (ArrayList<String> list) {
		
		// Get the longest String 
		 ArrayList<String>  result = new ArrayList<>();
		
		return result;
	}

}
