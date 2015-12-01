package ctci.ch4.prob9;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Random;

import algorithms.ds.tree.binary.BinarySearchTree;
import algorithms.ds.tree.binary.BinaryTreeNode;
import algorithms.utilities.UtilityMethods;

public class Problem9<T> {

    public static void main(
            String args[]) {

        BinarySearchTree tree = new BinarySearchTree<Integer>();

        Random randGenerator = new Random();

        // int nodeCount = Integer.parseInt(args[0]);
        int arr[] = {10, 30, 70, 10, 36, 60, 80, 32, 10, 65, 75, 85};

        for (int i = 0; i < 10; i++) {
            //Integer data = randGenerator.nextInt(10);
            Integer data = arr[i];
            System.out.print(data + "  ");
            tree.insert(data);
        }
        
        // loop to insert the count items in the tree
        for (int i = 0; i < 20; i++) {
            Integer data = randGenerator.nextInt(10);
            // Integer data = arr[i];
            System.out.print(data + "  ");
            tree.insert(data);
        }

        System.out.println();

        ArrayList<LinkedList<BinaryTreeNode<Integer>>> pathList = new ArrayList<LinkedList<BinaryTreeNode<Integer>>>();

        GetPathsOfEquivalentSum (tree.getRoot(), 10, pathList);
        
        int i = 1;
        /**
         * Traverse through all the paths to display the paths
         */
        for (LinkedList<BinaryTreeNode<Integer>> list : pathList) {

            System.out.println("Path # : " + i);

            for (BinaryTreeNode<Integer> node : list) {

                System.out.print(node.getData() + "  ");
            }

            System.out.println("");
            i++;
        }
    }

    private static <T> void GetPathsOfEquivalentSum(
            BinaryTreeNode<T> root,
            final int sum,
            ArrayList<LinkedList<BinaryTreeNode<T>>> pathList) {

        if (root == null) {
            return;
        }

        /**
         * Check if the current node is having data equal to the sum.
         */
        if ((Integer) root.getData() == sum) {
            LinkedList<BinaryTreeNode<T>> list = new LinkedList<BinaryTreeNode<T>>();
            list.add(root);
            pathList.add(list);
        }

        LinkedList<BinaryTreeNode<T>> leftpath = new LinkedList<BinaryTreeNode<T>>();
        leftpath.add(root);

        if (isLeftPathPresent(root.getLeftChild(), (Integer) root.getData(), sum, leftpath) == true) {

            pathList.add(leftpath);

        }

        LinkedList<BinaryTreeNode<T>> rightpath = new LinkedList<BinaryTreeNode<T>>();
        rightpath.add(root);

        if (isLeftPathPresent(root.getRightChild(), (Integer) root.getData(), sum, rightpath) == true) {
            pathList.add(rightpath);
        }
        
        GetPathsOfEquivalentSum(root.getLeftChild(),
                sum, pathList);

        GetPathsOfEquivalentSum(root.getRightChild(),
                sum, pathList);
    }

    private static <T> boolean isLeftPathPresent(
            final BinaryTreeNode<T> root,
            int curSum,
            final int sum,
            final LinkedList<BinaryTreeNode<T>> pathList) {

        if (root == null) {
            return false;
        }

        pathList.add(root);

        curSum += (Integer) root.getData();

        if (curSum == sum) {
            return true;
        }

        return isLeftPathPresent(root.getLeftChild(), curSum, sum, pathList);
    }

    private static <T> boolean isRightPathPresent(
            final BinaryTreeNode<T> root,
            int curSum,
            final int sum,
            final LinkedList<BinaryTreeNode<T>> pathList) {

        if (root == null) {
            return false;
        }

        pathList.add(root);

        curSum += (Integer) root.getData();

        if (curSum == sum) {
            return true;
        }

        return isRightPathPresent(root.getRightChild(), curSum, sum, pathList);
    }

}
