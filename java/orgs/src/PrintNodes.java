public class PrintNodes {

	public static class Node {
		public int data;
		public Node left = null;
		public Node right = null;

		public Node(final int data) {
			this.data = data;
		}
	}

	public static class Ancestor {
		public Node node = null;
		int pos = -1;
	}

	public static void main(final String[] args) {
		// Case: when there is no node in the tree
		// traverseNodesAtDistance(null, 67, 2);

		/*
		 * Building the following tree 100 50 150 30 68 175 56 70 65 90
		 */

		final Node root = new Node(100);

		root.left = new Node(50);
		root.right = new Node(150);
		root.right.right = new Node(175);
		root.left.left = new Node(30);
		root.left.right = new Node(68);
		root.left.right.right = new Node(70);
		root.left.right.right.right = new Node(90);
		root.left.right.left = new Node(56);
		root.left.right.left.right = new Node(65);

		// Case1 : when the argument is not valid Throws exception
		// traverseNodesAtDistance(root, 67, 2);

		System.out.println("\n-----Finding Ndoes At Distnace 2--------");

		// Case2: at distance 2
		traverseNodesAtDistance(root, 68, 2);

		// System.out.println("\n-----Finding Ndoes At Distnace 3--------");

		// Case3: at distance 3
		// traverseNodesAtDistance(root, 68, 3);

		// System.out.println("\n-----Finding Ndoes At Distnace 4--------");

		// Case4: traverse at distance 4
		// traverseNodesAtDistance(root, 68, 4);
	}

	public static void traverseNodesAtDistance(Node root, int value, int distance) {
		Node node = findNode(root, value);

		// Single palce to handle all the exceptions.
		if (node == null) {
			throw new IllegalArgumentException("There is no node present with value : " + value);
		}

		traverseNodesDown(node, distance);

		traverseNodesUP(root, node, distance);
	}

	private static Node findNode(Node root, int value) {
		// Not throwing exception here to streamline the exception handling in
		// the calling method.
		if (root == null) {
			return null;
		}

		if (root.data == value) {
			return root;
		}

		if (root.data > value) {
			return findNode(root.left, value);
		} else if (root.data < value) {
			return findNode(root.right, value);
		}

		// this exception will also be handled by the calling method
		return null;
	}

	private static void traverseNodesDown(Node node, int distance) {
		if (node == null)
			return;
		;

		if (distance == 0) {
			System.out.print(node.data + " ");
			return;
		}

		traverseNodesDown(node.left, distance - 1);
		traverseNodesDown(node.right, distance - 1);
	}

	public static int findAncestors(Node root, Ancestor[] ancestors, int p, Node node) {
		if (root == null)
			return 0;

		ancestors[p] = new Ancestor();
		ancestors[p].node = root;

		if (root.data == node.data) {
			ancestors[p].pos = 0;
			return p;
		}

		int l = findAncestors(root.left, ancestors, p + 1, node);
		if (l > 0) {
			ancestors[p].pos = 1;
			return l;
		}

		int r = findAncestors(root.right, ancestors, p + 1, node);
		if (r > 0) {
			ancestors[p].pos = 2;
			return r;
		}

		return 0;
	}

	/*
	 * The idea here is to find all the ancesters first and then check find all
	 * the nodes from each ancestor which is having a distance = dist
	 */

	private static void traverseNodesUP(Node root, Node node, int dist) {
		Ancestor[] ancestors = new Ancestor[10];

		int pos = findAncestors(root, ancestors, 1, node);
		if (pos <= 0)
			return;

		for (int i = 1; i < pos; i++) {
			if (pos - i == dist) {
				System.out.print(ancestors[i].node.data + " ");
			} else if (pos - i < dist) {
				int count = dist - (pos - i) - 1;

				if (ancestors[i].pos == 1)
					traverseNodesDown(ancestors[i].node.right, count);

				else
					traverseNodesDown(ancestors[i].node.left, count);
			}
		}
	}

}