package leetcode.prob95;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Solution {

	public static class TreeNode {

		int n;
		TreeNode left;
		TreeNode right;

		TreeNode(int n) {
			this.n = n;
		}
	}

	public List<TreeNode> generateTrees(int n) {
		
		
		LinkedList<TreeNode> bsts = new LinkedList<>();
		//int a [] = new int [n+1];
		
		//TreeNode [] nodes = new TreeNode [n+1];
		ArrayList<TreeNode> lists = new ArrayList<> ();
		
		for (int i = 1; i <= n; i++) {
			
			if (i==1) {
				TreeNode root = new TreeNode (1);
				lists.add(root);
				//ArrayList<TreeNode> list = new ArrayList<> ();
				//a[i] = 1;
				//a[0] = 1;
			}
			
			TreeNode root = new TreeNode (i);
			
			int last = i-1;
			int res = 0;
			
			for (int j = 0; j <= last; j++) {
				
				TreeNode root1 = new TreeNode (i);
				
				if (j!=0)
					root1.left = lists.get(j-1);
				if (last-j!=0)
					root1.right = lists.get(last-j-1);
				
				
				//res+= a[j]*a[last-j];
			}
			
			
			bsts.add(root);
		}
		
		return bsts;
	}
}