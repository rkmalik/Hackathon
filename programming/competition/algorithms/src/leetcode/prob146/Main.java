package leetcode.prob146;
public class Main {
	
	
	public static void main (String args[]) {
		
		LRUCache sol = new LRUCache (2);
		
		/*System.out.println("[set(2, 1)]");
		sol.set(2, 1);
		
		System.out.println("get[2] " + sol.get(2));

		System.out.println("[set(3, 2)]");
		sol.set(3, 2);
		
		System.out.println("get[2] " + sol.get(2));
		System.out.println("get[3] " + sol.get(3));*/
		
		/*System.out.println("[set(2, 1)]");
		sol.set(2, 1);
		
		System.out.println("get[2] " + sol.get(2));

		System.out.println("[set(2, 2)]");
		sol.set(2, 2);


		System.out.println("[set(1, 1)]");
		sol.set(1, 1);

		

		System.out.println("[set(4, 4)]");
		sol.set(4, 4);

		
		System.out.println("get[2] " + sol.get(2));
		System.out.println("get[3] " + sol.get(3));*/
		
		
		/*System.out.println("[set(2, 1)]");
		sol.set(2, 1);
		
		System.out.println("[set(1, 1)]");
		sol.set(1, 1);
		
		System.out.println("get[2] " + sol.get(2));

		

		System.out.println("[set(4, 1)]");
		sol.set(4, 1);

		
		System.out.println("get[1] " + sol.get(1));
		System.out.println("get[2] " + sol.get(2));*/
		
		
		String input = "[set(2,1),set(1,1),get(2),set(4,1),get(1),get(2)]";
		String output  = "[";
		sol.set(2, 1);
		sol.set(1, 1);
		output += sol.get(2);
		sol.set(4, 1);
		output += sol.get(1);
		output += sol.get(2);
		output += "]";
		
		System.out.println(input);
		System.out.println(output);
	}

}