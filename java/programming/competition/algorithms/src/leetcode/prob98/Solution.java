package leetcode.prob98;
public class Solution {
    
    private Integer last = null;

    public boolean isValidBST(
            TreeNode root) {
        if (root == null)
            return true;

        if (isValidBST(root.left) == false)
            return false;

        if (last != null && root.val <= last) {
            return false;
        }

        last = root.val;

        if (isValidBST(root.right) == false)
            return false;

        return true;
    }
}