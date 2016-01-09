package leetcode.prob102;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Stack;

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
    public List<List<Integer>> levelOrder(TreeNode root) {
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        
        if (root == null) return result;
        
        // Allocate these two array list only when these are required.        
        ArrayList<Integer> vals = null;
        ArrayList<TreeNode> next = null;
        
        
        ArrayList<TreeNode> current = new ArrayList<TreeNode> ();
        current.add(root);
       
        
        while (current.isEmpty() == false) {
            
            TreeNode node = current.remove(0);
            
            if (next == null) {
                next = new ArrayList<TreeNode> ();
            }
            
            if (vals == null) {
                vals = new ArrayList<Integer> ();
            }
            
            if (node.left != null){
               next.add(node.left); 
            }
                

            if (node.right != null) {
                next.add(node.right);
            }
                
                
            vals.add(node.val);
            
            if (current.isEmpty()) {
                
                current = next;
                result.add(vals);
                vals = null;
                next = null;
            }
            
        }
        return result;
    }
}