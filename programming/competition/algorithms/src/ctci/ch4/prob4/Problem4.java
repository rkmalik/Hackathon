package ctci.ch4.prob4;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.Random;

import algorithms.ds.tree.binary.BinarySearchTree;
import algorithms.ds.tree.binary.BinaryTreeNode;
import algorithms.utilities.UtilityMethods;

public class Problem4<T> {

    public static void main(
            String args[]) {

        BinarySearchTree tree = new BinarySearchTree<Integer>();

        Random randGenerator = new Random();

        // int nodeCount = Integer.parseInt(args[0]);
        int arr[] = {50, 30, 70, 20, 36, 60, 80, 32, 40, 65, 75, 85};

        // loop to insert the count items in the tree
        for (int i = 0; i < 20; i++) {
            Integer data = randGenerator.nextInt(100);
            //Integer data = arr[i];
            System.out.print(data + "  ");
            tree.insert(data);
        }

        System.out.println();
        HashMap<Integer, LinkedList<BinaryTreeNode<Integer>>> levellist 
            = new HashMap<Integer, LinkedList<BinaryTreeNode<Integer>>>();
        
        createLeveledLinkList(tree.getRoot(), levellist, 0);

        /**
         * Treaverse through hash map
         * */
        for (Map.Entry<Integer, LinkedList<BinaryTreeNode<Integer>>> entry : levellist.entrySet()) {
            
            System.out.println("List for level : " + entry.getKey());
            
            LinkedList<BinaryTreeNode<Integer>> list = entry.getValue();
            
            for (BinaryTreeNode<Integer> node : list) {
                
                System.out.print(node.getData() + "  ");
            }
            System.out.println("");
        }
    }

    private static <T> void createLeveledLinkList(
            BinaryTreeNode<T> root,
            HashMap<Integer, LinkedList<BinaryTreeNode<T>>> levellist,
            int level) {

        if (root != null) {
            
            LinkedList<BinaryTreeNode<T>> list = levellist.get(level);
            if (list == null) {
                list = new LinkedList<BinaryTreeNode<T>> ();
                levellist.put(level, list);
            }
            
            list.add(root);
            createLeveledLinkList(root.getLeftChild(), levellist, level+1);
            createLeveledLinkList(root.getRightChild(), levellist, level+1);
        }

    }

}
