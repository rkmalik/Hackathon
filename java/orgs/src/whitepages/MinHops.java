package whitepages;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MinHops {

    private static class Node {
        int minHops;
        int forwardJump;
        int index;
        List<Node> predecessors = new ArrayList<>();

        Node(int distanceFromStart, int value, int index) {
            this.minHops = distanceFromStart;
            this.forwardJump = value;
            this.index = index;
        }
    }

    public static void allMinHopsToEnd(int[] arr) {
        Node[] store = new Node[arr.length];
        store[0] = new Node(0, arr[0], 0);
        for (int i = 1; i < arr.length; i++) {
            store[i] = new Node(Integer.MAX_VALUE, arr[i], i);
        }

        for (int index = 0; index < arr.length; index++) {
            try {
                updateHopsInRange(arr, store, index);
            } catch (RuntimeException r) {
                System.out.println("failure");
                return;
            }
        }

        Node end = store[store.length-1];
        List<ArrayList<Node>> paths = pathsTo(end);
        //System.out.println("min jumps for: " + Arrays.toString(arr));
        String str = ", ";
        StringBuilder sb = new StringBuilder();
        for (ArrayList<Node> path : paths) {
        	for (Node node : path) {
        		sb.append(node.index + str);
        	}
        }
        
        sb.append("out");
        System.out.println(sb);
    }

    private static void updateHopsInRange(int[] arr, Node[] store, int currentIndex) {
        if (store[currentIndex].minHops == Integer.MAX_VALUE) {
            throw new RuntimeException("unreachable node");
        }

        int range = arr[currentIndex];
        for (int i = currentIndex + 1; i <= (currentIndex + range); i++) {
            if (i == arr.length) return;
            int currentHops = store[i].minHops; 
            int hopsViaNewNode = store[currentIndex].minHops + 1;

            if (hopsViaNewNode < currentHops) { //strictly better path
                store[i].minHops = hopsViaNewNode;
                store[i].predecessors.clear();
                store[i].predecessors.add(store[currentIndex]);
            } else if (hopsViaNewNode == currentHops) { //equivalently good path
                store[i].predecessors.add(store[currentIndex]);
            }
        }
    }

    private static List<ArrayList<Node>> pathsTo(Node node) {
        List<ArrayList<Node>> paths = new ArrayList<ArrayList<Node>>();
        if (node.predecessors.size() == 0) {
            paths.add(new ArrayList<>(Arrays.asList(node)));
        }

        for (Node pred : node.predecessors) {
            List<ArrayList<Node>> pathsToPred = pathsTo(pred);
            for (ArrayList<Node> path : pathsToPred) {
                path.add(node);
            }

            paths.addAll(pathsToPred);
        }

        return paths;
    }

    public static void main(String[] args) {
        int[] arr = {4, 0, 0, 3, 6, 5, 4, 7, 1, 0, 1, 2};
        
        int[] arr1 = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
        int[] arr2 = {2, 3, 1, 1, 4};
        int[] arr3 = {1, 0, 0, 4, 0};
        
        int [] arr4 = {5,6,0,4,2,4,1,0,0,4};
        int[] arr5 = {1,1};
        allMinHopsToEnd(arr);
        /*allMinHopsToEnd(arr);
        allMinHopsToEnd(arr1);
        allMinHopsToEnd(arr2);
        allMinHopsToEnd(arr3);*/
    }

}