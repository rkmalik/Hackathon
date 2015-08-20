package algorithms.ds.tree.binary;

public class BinaryTreeNode<T> {

    private T data;
    private BinaryTreeNode<T> leftChild;
    private BinaryTreeNode<T> rightChild;
    private BinaryTreeNode<T> parent;

    public BinaryTreeNode(
            T data) {
        this.data = data;
        this.leftChild = null;
        this.rightChild = null;
        this.parent = null;
    }

    T getData() {
        return data;
    }

    void setData(
            T data) {
        this.data = data;
    }

    BinaryTreeNode<T> getLeftChild() {
        return leftChild;
    }

    void setLeftChild(
            BinaryTreeNode<T> leftChild) {
        this.leftChild = leftChild;
    }

    BinaryTreeNode<T> getRightChild() {
        return rightChild;
    }

    void setRightChild(
            BinaryTreeNode<T> rightChild) {
        this.rightChild = rightChild;
    }

    BinaryTreeNode<T> getParent() {
        return parent;
    }

    void setParent(
            BinaryTreeNode<T> parent) {
        this.parent = parent;
    }
}
