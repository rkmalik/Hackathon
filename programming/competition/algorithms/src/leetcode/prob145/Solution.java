package leetcode.prob145;

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
    
    
    public List<Integer> postorderTraversal(TreeNode curRoot) {
        
        List<Integer> list = new LinkedList<Integer>();
        Stack<TreeNode> stack = new Stack<TreeNode>();
        
        if (curRoot == null)
            return list;
        
        do {
            
            while (curRoot != null) {
                
                if (curRoot.right != null)
                    stack.push(curRoot.right);
                stack.push(curRoot);
                curRoot = curRoot.left;
            }
            
            curRoot = stack.pop();
            
            /**
             * This explains the below cleaner code much better.
             * */
             /*if (stack.size() != 0) {
                
                if (curRoot.right == stack.peek()) {
                    TreeNode top = stack.pop();
                    stack.push(curRoot);
                    curRoot = top;
                } else {
                    list.add(curRoot.val);
                    curRoot = null;
                }
                
            } else if (curRoot.right == null) {
                list.add(curRoot.val);
                curRoot = null;
            } else {
                list.add(curRoot.val);
                curRoot = null;
            }*/
             
             /**
              * Below is more cleaner way to do the same thing.
              * 
              * */
            if ((stack.size() != 0) && (curRoot.right == stack.peek())) {
                    TreeNode top = stack.pop();
                    stack.push(curRoot);
                    curRoot = top;
            } else {          
                list.add(curRoot.val);
                curRoot = null;
            }
            
        } while (stack.isEmpty() == false);
        
        return list;
    }
}