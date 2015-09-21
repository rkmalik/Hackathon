package Zillows;

public class TernaryTree {
	
	private class Node {
		
		private int val;
		private Node left = null;
		private Node mid = null;
		private Node right = null;
		
		public Node (int val) {
			this.val = val;
		}
	}
	private Node root;
	
	public void display () {
		display(root);
	}
	
	private void display(Node root) {
		if (root == null) {
			return;
		}
		
		display(root.left);
		System.out.println(root.val);
		display(root.mid);
		display(root.right);

	}
	

	public void insert(int val) {
		root = insert(root, val);
	}
	
	private Node insert(Node root, int val) {
	    if (root == null) {
	      root = new Node(val);
	    } else if (val < root.val) {
	      root.left = insert(root.left, val);
	    } else if (val == root.val) {
	      root.mid = insert(root.mid, val) ;
	    } else {
	      root.right = insert(root.right, val);
	    }
	    return root;
	}
	
	
	public void delete (int val) {
		
		root = delete (root, val);
	}
	
	private Node delete(Node root, int val) {

		if (root == null) {
			return null;
		} else if (val < root.val) {
			root.left = delete(root.left, val);
		} else if (val > root.val) {
			root.right = delete(root.right, val);
		} else {
			if (root.mid != null) {
				root.mid = delete(root.mid, val);
			} else if (root.right != null) {
				root.val = getMinNode(root.right).val;
				root.right = delete(root.right, getMinNode(root.right).val);
			} else {
				root = root.left;
			}
		}
		return root;
	}
	
	private Node getMinNode(Node node) {
		if (node != null) {
			while (node.left != null) {
				return getMinNode(node.left);
			}
		}
		return node;
	}

}
