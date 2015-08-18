package algorithms.graph;

import java.util.List;
import java.util.Map;

public class DepthFirstSearch<T> {
    
    Graph<T> graph;
    
    public DepthFirstSearch (Graph<T> graph) {
        this.graph = graph;
    }
    
    
    public void DFS (T src) {
        
        for (Map.Entry<T, List<Edge<T>>> entry : graph.getAdjList().entrySet()) {
            
            if (graph.getVertices().get(entry.getKey()).isVisited() == false) {     
                DFS_Visited(entry.getKey(), entry.getValue());
            }
            
        }
        
        // Clear all the nodes once the DFS search is done.
        graph.clearAll();
    }
    
    private void DFS_Visited (T fromNode, List<Edge<T>> list) {
        
        System.out.println("Node Visited : " + fromNode);
        graph.getVertices().get(fromNode).setVisited(true);
        
        for (Edge<T> edge : list) {
            
            T from = edge.getFromVertex();
            
            if (graph.getVertices().get(from).isVisited() == false) {
                
                DFS_Visited (from, graph.getAdjList().get(from));
            }
        }
    }
}
