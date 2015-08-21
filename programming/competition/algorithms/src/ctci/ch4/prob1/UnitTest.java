package ctci.ch4.prob1;

import java.util.Random;

import algorithms.ds.tree.binary.BinarySearchTree;

public class UnitTest {

    public static void main(
            String args[]) {

        BinarySearchTree tree = new BinarySearchTree<Integer>();

        Random randGenerator = new Random();

        int nodeCount = Integer.parseInt(args[0]);
        

        // loop to insert the count items in the tree
        for (int i = 0; i < nodeCount; i++) {

            Integer data = randGenerator.nextInt(100);

            System.out.print(data + "  ");

            tree.insert(data);
        }

        System.out.println("\n\n");
        tree.inOrder(tree.getRoot());
        System.out.println("\n\n");
        tree.preOrder(tree.getRoot());
        System.out.println("\n\n");
        tree.postOrder(tree.getRoot());

    }

}
