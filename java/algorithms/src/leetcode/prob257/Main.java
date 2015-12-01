package leetcode.prob257;

public class Main {
	
	
	public static void main (String args[]) {
		
	    TreeNode root = new TreeNode (1);
	    root.right = new TreeNode (2);
	    Solution sol = new Solution();
	    System.out.println(sol.binaryTreePaths(root));
        
	}

}
