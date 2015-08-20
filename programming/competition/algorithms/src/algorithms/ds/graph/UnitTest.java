package algorithms.ds.graph;

import java.util.Random;

/**
 * This class prepares various unit test scenarios and run them.
 */
public class UnitTest {

    public static void main(
            String args[]) {
        
        Graph<Integer> graph = new Graph<Integer> ();
        Random randGenerator = new Random();
        
        
        for (int i = 0; i < 11; i++ ) {
            
            int random = randGenerator.nextInt(10);
            graph.addVertex(i);
            graph.addEdge(i, random, 0);
        }
        
        System.out.println(graph);

        DepthFirstSearch.DFS(graph, 0);
    }
}
