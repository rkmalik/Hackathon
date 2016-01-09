package ctci.ch4.prob4;

import java.util.LinkedList;

public class Solution {

	public class TreeNode {

		TreeNode left;
		TreeNode right;
		int data;

		TreeNode(int data) {
			this.data = data;
		}
	}

	LinkedList<LinkedList<TreeNode>> levelOrderTraversal(TreeNode root) {

		if (root == null) {
			return null;
		}

		LinkedList<LinkedList<TreeNode>> output = new LinkedList<>();
		LinkedList<TreeNode> list = new LinkedList<>();
		LinkedList<LinkedList<TreeNode>> q = new LinkedList<LinkedList<TreeNode>>();

		list.add(root);
		output.add(list);
		q.addLast(list);

		while (q.isEmpty() == false) {

			LinkedList<TreeNode> l = q.removeFirst();
			LinkedList<TreeNode> nlist = new LinkedList<TreeNode>();
			for (TreeNode n : l) {

				if (n.left != null)
					nlist.addLast(n.left);

				if (n.right != null)
					nlist.addLast(n.right);
			}

			if (nlist.isEmpty() == false) {
				output.add(nlist);
				q.addLast(nlist);
			}
		}

		return output;
	}

}