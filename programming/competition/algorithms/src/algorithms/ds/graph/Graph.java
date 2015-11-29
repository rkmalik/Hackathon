package algorithms.ds.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;

import org.apache.commons.lang3.Validate;

public class Graph<E> implements BaseGraph<E> {

    private HashMap<E, List<Edge<E>>> adjList;
    private HashMap<E, Vertex<E>> vertices;

    public Graph() {
        adjList = new HashMap<E, List<Edge<E>>>();
        vertices = new HashMap<E, Vertex<E>>();
    }
    
    public HashMap<E, Vertex<E>> getVertices () {
        return vertices;
    }
    
    public HashMap<E, List<Edge<E>>> getAdjList () {
        return adjList;
    }

    public void addVertex(
            E vertex) {

        Validate.notNull(vertex, "Vertex can not be ", vertex);

        /**
         * Add a vertex only if the vertex is not already present, else there is no need to add one. As it is already
         * present.
         */
        if (vertices.get(vertex) == null) {
            vertices.put(vertex, new Vertex<E>(vertex));
            // Create an entry in the adjacency list for vertex
            adjList.put(vertex, new LinkedList<Edge<E>>());
        }
    }

    public void addEdge(
            E fromVertex,
            E toVertex, int weight) {
        
        Validate.notNull(fromVertex, "from Vertex can not be ", fromVertex);
        Validate.notNull(toVertex, "to Vertex can not be ", toVertex);
        
        List<Edge<E>> list = adjList.get(fromVertex);

        Edge<E> edge = new Edge<E>(fromVertex, toVertex, weight);
        
        list.add(edge);
    }

    public boolean hasEdge(
            E fromVertex,
            E toVertex) {
        
        if (getEdge(fromVertex, toVertex) != null)
            return true;

        return false;
    }

    public Edge<E> getEdge(
            E fromVertex,
            E toVertex) {
        
        // First retrieve the list of all the edges attached to the fromVertex
        List<Edge<E>> list = adjList.get(fromVertex);
        
        if (list == null) {
            return null;
        }
        
        for (Edge<E> edge : list) {
            
            if(edge.getToVertex().equals(toVertex)) {
                return edge;
            }
        }

        return null;
    }
    
    public void clearAll () {
        for (Map.Entry<E, Vertex<E>> entry : vertices.entrySet()) {
            entry.getValue().setVisited(false);
        }
    }

    public String toString() {
        
        String display = "";
        
        for (Map.Entry<E, List<Edge<E>>> entry : adjList.entrySet()) {
            
            display += "From -> " + entry.getKey() + " ";
            
            List<Edge<E>> list = entry.getValue();
            
            for (Edge<E> edge : list) {
                display += " to " + edge.getToVertex();
            }
            
            display += "\n\n";
        }
        
        return display;
    }

}
