package collection;

import java.util.HashMap;
import java.util.Map.Entry;

public class TestHashMap {

	public static class Dog {

		String name;

		public Dog(String name) {

			this.name = name;
		}

		public String getName() {

			return name;
		}
	}

	public static void main(String args[]) {

		HashMap<Dog, Integer> dogmap = new HashMap<Dog, Integer>();

		dogmap.put(new Dog("A"), 1);
		dogmap.put(new Dog("B"), 2);
		dogmap.put(new Dog("C"), 3);
		dogmap.put(new Dog("D"), 4);

		for (Entry<Dog, Integer> entry : dogmap.entrySet()) {
			System.out.println("Dog Name : " + entry.getKey().getName () + " Dog Id : " + entry.getValue());
		}
	}

}