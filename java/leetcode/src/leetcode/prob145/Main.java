package leetcode.prob145;

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
        
        List<Integer> list = sol.postorderTraversal(root);
        
        System.out.println(list);

        
        root = new TreeNode(3);
        node = new TreeNode (1);
        root.left = node;
        node1 = new TreeNode(2);
        node.right = node1;
        
        list = sol.postorderTraversal(root);
        
        System.out.println(list);
    }

}
