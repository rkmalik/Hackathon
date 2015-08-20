package algorithms.ds.tree.binary;

/**
 * This is the library class which provides the Tree data structure functionality.
 * 
 * 
 */
public class BinarySearchTree <T extends Comparable<T>> {

    private BinaryTreeNode<T> root;
    int size;

    public BinarySearchTree() {
        root = null;
        size = 0;
    }

    public BinaryTreeNode<T> getRoot() {
        return root;
    }
    
    public int getSize() {
        return size;
    }

    /**
     * Iterative approach to insert the data to the tree.
     * 
     */
    public void insert(
            T data) {

        // check if this is the root node
        if (root == null) {
            BinaryTreeNode<T> node = new BinaryTreeNode<T>(data);
            root = node;
            size++;
            return;
        }

        BinaryTreeNode<T> iterator = root;

        while (true) {

            BinaryTreeNode<T> child = null;

            if (data.compareTo(iterator.getData()) <= 0) {             //if (data <= iterator.getData()) {

                child = iterator.getLeftChild();

                // Child is null, then this is the node where we need to insert the
                // new node
                if (child == null) {
                    BinaryTreeNode<T> node = new BinaryTreeNode<T>(data);
                    node.setParent(iterator);
                    iterator.setLeftChild(node);
                    size++;
                    break;
                }

            } else {

                child = iterator.getRightChild();
                // Child is null, then this is the node where we need to insert the
                // new node
                if (child == null) {
                    BinaryTreeNode<T> node = new BinaryTreeNode<T>(data);
                    node.setParent(iterator);
                    iterator.setRightChild(node);
                    size++;
                    break;
                }
            }
            iterator = child;
        }
    }

    public BinaryTreeNode<T> delete(
            T data) {
        
        BinaryTreeNode<T> node = search (data);
        BinaryTreeNode<T> parent = node.getParent();
        
        // When node is not having any child 
        if (node.getLeftChild() == null && node.getRightChild() == null) {
            
            // Check if this is a left child or right child of the parent
            
            // if this is the root node and this don't have any children do nothing 
            // set the root as null
            if (parent == null){ 
                root = null;
            //} else if (parent.getData() > data) {
            } else if (data.compareTo(parent.getData()) < 0) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }
            
            // If the node is having both the children
        } else if (node.getLeftChild() != null && node.getRightChild() != null) {
            
            
            // I need to find the inorder successor of the node. 
            BinaryTreeNode<T> inOrderSuccessor = node.getRightChild();
            
            while (inOrderSuccessor.getLeftChild() != null) {
                inOrderSuccessor = inOrderSuccessor.getLeftChild();
            }
            
            node.setData(inOrderSuccessor.getData());
            
            // Now this is simple case as the first one.
            parent = inOrderSuccessor.getParent();
            
            //if (parent.getData() > data) {
            if (data.compareTo(parent.getData()) < 0) {
                parent.setLeftChild(null);
            } else {
                parent.setRightChild(null);
            }            
            
            // remaining case is when the node is having only one child.
        } else {
            
            BinaryTreeNode<T> child = node.getLeftChild() != null ? node.getLeftChild() : node.getRightChild();
            
            //if (parent.getData() > data) {
            if (data.compareTo(parent.getData()) < 0) {
                parent.setLeftChild(child);
            } else {
                parent.setRightChild(child);
            }   
        }

        return null;
    }
    
    /**
     * This method returns the node which is holding the data
     * This implementation is iterative and same can be implemented in recursive manner.
     * */
    public BinaryTreeNode<T> search(
            T data) {
        
        BinaryTreeNode<T> iterator = root;
        
        while(iterator != null) {
            
            //if (data == iterator.getData()) {
            if (data.compareTo(iterator.getData()) == 0) {
                return iterator;
            } else if (data.compareTo(iterator.getData()) < 0) { // data < iterator.getData()
                iterator = iterator.getLeftChild();
            } else {
                iterator = iterator.getRightChild();
            }
        }
        
        // This means there is no matching node.
        return null;
    }

    public void inOrder(
            BinaryTreeNode<T> node) {

        if (node == null)
            return;

        inOrder(node.getLeftChild());

        System.out.print(node.getData() + "  ");

        inOrder(node.getRightChild());

    }

    public void preOrder(
            BinaryTreeNode<T> node) {

        if (node == null)
            return;

        System.out.print(node.getData() + "  ");
        preOrder(node.getLeftChild());
        preOrder(node.getRightChild());

    }

    public void postOrder(
            BinaryTreeNode<T> node) {

        if (node == null) {
            return;
        }

        postOrder(node.getLeftChild());
        postOrder(node.getRightChild());
        System.out.print(node.getData() + "  ");
    }

}
