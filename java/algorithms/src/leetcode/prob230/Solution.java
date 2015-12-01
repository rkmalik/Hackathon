package leetcode.prob230;

import java.util.LinkedList;
import java.util.Stack;

public class Solution {
    
    class NodeSeq  {
        
            int seqNum;
            
            public NodeSeq () {
                seqNum = 0;
            }
        }
    
    public int kthSmallest(TreeNode root, int k) {
        
        TreeNode node = getKthNode (root, k, new NodeSeq());
        
        if (node != null) return node.val;
        
        return -1;
        
    }


    
    private TreeNode getKthNode(TreeNode root, int k, NodeSeq seq) {
        
        if (k == 0 || root == null) return null;
        
        TreeNode node = getKthNode (root.left, k, seq);
        
        if (node != null)
            return node;
        
        
        seq.seqNum++;
        
        if (seq.seqNum == k) return root;
        
        node = getKthNode (root.right, k, seq);
        
        return node;
    }
}