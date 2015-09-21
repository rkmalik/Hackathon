package Zillows;

public class mainClass {

	public static void main(String[] args) {
		TernaryTree tree = new TernaryTree();
		int[] a = { 5, 4, 9, 5, 7, 2, 2 };
		for (int i = 0; i < a.length; i++) {
			tree.insert(a[i]);
		}
		
		
		
		/*tree.delete(5);
		tree.delete(5);*/
		
		tree.insert(1);
		
		tree.display();
		System.out.println("Delete 1----------------");
		tree.delete(1);
		tree.display();
		System.out.println("----------------");
		
		tree.insert(2);
		tree.insert(3);
		
		tree.display();
		System.out.println("Delete 2----------------");
		tree.delete(2);
		tree.display();
		
		
		System.out.println("Delete 1----------------");
		tree.delete(1);
		tree.delete(1);
		tree.display();
		
		
		System.out.println("Delete 3----------------");
		tree.delete(3);
		tree.display();
		
		System.out.println("Insert 4----------------");
		tree.insert(4);
		tree.display();

	}

}