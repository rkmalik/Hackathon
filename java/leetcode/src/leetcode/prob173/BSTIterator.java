package leetcode.prob173;

import java.util.Stack;

import leetcode.prob297.Codec.TreeNode;

/**
 * Definition for binary tree public class TreeNode { int val; TreeNode left;
 * TreeNode right; TreeNode(int x) { val = x; } }
 */

public class BSTIterator {

	public static class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	private Stack<TreeNode> stack = null;
	private TreeNode cur = null;

	public BSTIterator(TreeNode root) {
		stack = new Stack<>();
		while (root != null) {
			stack.push(root);
			root = root.left;
		}
	}

	/** @return whether we have a next smallest number */
	public boolean hasNext() {

		if (!stack.isEmpty()) {
			return true;
		}
		return false;
	}

	/** @return the next smallest number */
	public int next() {

		TreeNode nxt = cur = stack.pop();

		if (cur.right != null) {
			cur = cur.right;
			stack.push(cur);
			while (cur.left != null) {
				cur = cur.left;
				stack.push(cur);
			}
		}
		return nxt.val;
	}
}

/**
 * Your BSTIterator will be called like this: BSTIterator i = new
 * BSTIterator(root); while (i.hasNext()) v[f()] = i.next();
 */