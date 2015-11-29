package leetcode.prob102;

import java.util.LinkedList;
import java.util.List;

public class Main {
    
    public static void  main (String args []) {
        
        
        TreeNode root = new TreeNode(2);
        TreeNode node = new TreeNode (3);
        root.right = node;
        TreeNode node1 = new TreeNode(4);
        node.left = node1;
        node1.right = new TreeNode(1);
        
        Solution sol = new Solution();
        
        List<List<Integer>> list = sol.levelOrder(root);
        
        System.out.println(list);

        
    }

}
