package algorithms.ds.tree.binary;

public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private BinaryTreeNode<T> parent;
    int height;
    
    public BinaryTreeNode(
            T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
        height = 0;
    }

    public T getData() {
        return data;
    }

    public void setData(
            T data) {
        this.data = data;
    }

    public BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    public void setLeftChild(
            BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    public BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    public void setRightChild(
            BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    public BinaryTreeNode<T> getParent() {
        return parent;
    }

    public void setParent(
            BinaryTreeNode<T> parent) {
        this.parent = parent;
    }
    
    public int getHeight () {
        return height;
    }
    
    public void setHeight(int height) {
        this.height = height;
    }
    
}
