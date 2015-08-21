package ctci.ch4.prob1;

import java.util.Random;

import algorithms.ds.tree.binary.BinarySearchTree;
import algorithms.ds.tree.binary.BinaryTreeNode;
import algorithms.utilities.UtilityMethods;

public class Problem1 {

    public static void main(
            String args[]) {

        BinarySearchTree tree = new BinarySearchTree<Integer>();

        Random randGenerator = new Random();

        // int nodeCount = Integer.parseInt(args[0]);
        int arr[] = {50, 30, 70, 20, 36, 60, 80, 32, 40, 65, 75, 85};

        // loop to insert the count items in the tree
        for (int i = 0; i < 10; i++) {
            // Integer data = randGenerator.nextInt(100);
            Integer data = arr[i];
            System.out.print(data + "  ");
            tree.insert(data);
        }

        if (isBalancedTree(tree.getRoot()) == true)
            System.out.println("\n\nBinary Tree is a balanced Tree.");
        else
            System.out.println("\n\nBinary Tree is an UnBalanced Tree.");
    }

    /**
     * This logic is based on the post order traversal.
     * 
     */
    private static boolean isBalancedTree(
            BinaryTreeNode root) {

        if (root != null) {

            if (isBalancedTree(root.getLeftChild()) == false 
                    || isBalancedTree(root.getRightChild()) == false)
                return false;

            int leftHt = root.getLeftChild() == null ? 0 : root.getLeftChild().getHeight();
            int rightHt = root.getRightChild() == null ? 0 : root.getRightChild().getHeight();

            root.setHeight(UtilityMethods.max(leftHt, rightHt) + 1);

            if (UtilityMethods.difference(leftHt, rightHt) > 1) {
                return false;
            }
        }

        return true;
    }
}
