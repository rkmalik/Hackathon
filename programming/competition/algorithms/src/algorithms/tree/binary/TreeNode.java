package algorithms.tree.binary;

public class TreeNode {

    
    private int data;
    private TreeNode leftChild;
    private TreeNode rightChild;
    

    public TreeNode (int data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
    }
    
    int getData() {
        return data;
    }
    
    void setData(int data) {
        this.data = data;
    }
    
    
    TreeNode getLeftChild() {
        return leftChild;
    }
    
    void setLeftChild(TreeNode leftChild) { 
        this.leftChild = leftChild;
    }
    
    TreeNode getRightChild() {
        return rightChild;
    }
    
    void setRightChild(TreeNode rightChild) {
        this.rightChild = rightChild;
    }
}
