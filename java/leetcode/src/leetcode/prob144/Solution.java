package leetcode.prob144;

import java.util.LinkedList;
import java.util.List;


import algorithms.ds.stack.StackArrayBased;

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    List<TreeNode> stack = new LinkedList<TreeNode> ();
    
    
    public List<Integer> preorderTraversal(TreeNode root) {
        
        TreeNode node = null;
        List<Integer> list = new LinkedList<Integer>();
        
        if (root == null)
            return list;
        
        stack.add(0, root);
        
        while (stack.isEmpty() == false) {
            
            node = stack.remove(0);
            list.add(node.val);
            
            if (node.right != null) {
                stack.add(0, node.right);
            }
            
            if (node.left != null) {
                stack.add(0, node.left);
            }
        }
        
    	return list;
    }
}