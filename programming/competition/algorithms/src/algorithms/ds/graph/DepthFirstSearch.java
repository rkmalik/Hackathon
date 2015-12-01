package algorithms.ds.graph;

import java.util.List;
import java.util.Map;

public class DepthFirstSearch<E> {
    
    public static <E> void DFS (Graph<E> graph, E src) {
        
        for (Map.Entry<E, List<Edge<E>>> entry : graph.getAdjList().entrySet()) {
            
            if (graph.getVertices().get(entry.getKey()).isVisited() == false) {     
                DFS_Visited(graph, entry.getKey(), entry.getValue());
            }
            
        }
        
        // Clear all the nodes once the DFS search is done.
        graph.clearAll();
    }
    
    private static <E> void DFS_Visited (Graph<E> graph, E fromNode, List<Edge<E>> list) {
        
        System.out.println("Node Visited : " + fromNode);
        graph.getVertices().get(fromNode).setVisited(true);
        
        for (Edge<E> edge : list) {
            
            E from = edge.getFromVertex();
            
            if (graph.getVertices().get(from).isVisited() == false) {
                
                DFS_Visited (graph, from, graph.getAdjList().get(from));
            }
        }
    }
}
