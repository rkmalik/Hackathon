package algorithms.tree.binary;

import java.util.Random;
import java.util.Scanner;
import java.lang.Object;

/**
 * This class creates a new tree and prepares all the nodes of the tree. This performs different tree operations based
 * on user choice.
 * 
 */
public class UnitTest {

    public static void main(
            String args[]) {

        BinarySearchTree tree = null;

        Random randGenerator = new Random();

        int nodeCount = Integer.parseInt(args[0]);
        String dataType = args[1];

        TreeDataType type = TreeDataType.fromString(dataType);

        switch (type) {

            case INTEGER:
                tree = new BinarySearchTree<Integer>();
                break;

            case DOUBLE:
                tree = new BinarySearchTree<Double>();
                break;

            case STRING:
                tree = new BinarySearchTree<String>();
                break;

            case INVALID:
                System.out.println("Invalid data type selected.");
                return;
        }

        // loop to insert the count items in the tree
        for (int i = 0; i < nodeCount; i++) {

            switch (type) {

                case INTEGER: {
                    Integer data = randGenerator.nextInt(100);

                    System.out.print(data + "  ");

                    tree.insert(data);
                }
                    break;
                case DOUBLE: {

                    Double data = randGenerator.nextDouble();

                    System.out.print(data + "  ");

                    tree.insert(data);
                }
                    break;

                case STRING:

                    break;

                case INVALID:
                    return;

            }
        }
        
        System.out.println("\n\n");
        tree.inOrder(tree.getRoot());
        System.out.println("\n\n");
        tree.preOrder(tree.getRoot());
        System.out.println("\n\n");
        tree.postOrder(tree.getRoot());

    }
    
    
    /*
     * public static void integerBasedTree () { Random randGenerator = new Random(); }
     * 
     * public static void doubleBasedTree () { Random randGenerator = new Random(); }
     * 
     * public static void stringBasedTree () { Random randGenerator = new Random(); }
     * 
     * public static display (BinarySearchTree tree) {
     * 
     * }
     */
}
