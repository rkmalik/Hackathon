package leetcode.prob257;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    
    private List<String> list = new ArrayList<String>();
    public List<String> binaryTreePaths(TreeNode root) {
        
        String path = "";
        findTreePaths(root, path);
        return list;
    }
    
    private void findTreePaths(TreeNode root, String path) {
        
        if (root == null) {
            return;
        }
        String path1;
        
        if (path.isEmpty()) {
            path1 = String.valueOf(root.val);
        }else {
            path1 = path +"->" + String.valueOf(root.val);
        }
        

        findTreePaths(root.left, path1);
        findTreePaths(root.right, path1);
        
        if (root.left == null && root.right == null) {
            list.add(path1);
        }
    }
}