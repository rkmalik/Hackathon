package leetcode.prob98;


public class Main {
    
    public static void main (String args[]) {
        
        
        Solution sol = new Solution ();
        
        TreeNode root = new TreeNode(-2147483648);
        TreeNode node = new TreeNode(-2147483648);
        
        root.left = node;
        System.out.println(sol.isValidBST(root));
    }

}
