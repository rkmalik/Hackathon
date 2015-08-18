package algorithms.graph;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import org.apache.commons.lang3.Validate;

public class Graph<T> implements BaseGraph<T> {

    HashMap<T, List<Edge<T>>> adjList;
    HashMap<T, Vertex<T>> vertices;

    public Graph() {
        adjList = new HashMap<T, List<Edge<T>>>();
        vertices = new HashMap<T, Vertex<T>>();
    }

    public void addVertex(
            T vertex) {

        Validate.notNull(vertex, "Vertex can not be ", vertex);

        /**
         * Add a vertex only if the vertex is not already present, else there is no need to add one. As it is already
         * present.
         */
        if (vertices.get(vertex) == null) {
            vertices.put(vertex, new Vertex<T>(vertex));
            // Create an entry in the adjacency list for vertex
            adjList.put(vertex, new LinkedList<Edge<T>>());
        }
    }

    public void addEdge(
            T fromVertex,
            T toVertex, int weight) {
        
        Validate.notNull(fromVertex, "from Vertex can not be ", fromVertex);
        Validate.notNull(toVertex, "to Vertex can not be ", toVertex);
        
        List<Edge<T>> list = adjList.get(fromVertex);

        Edge<T> edge = new Edge<T>(fromVertex, toVertex, weight);
        
        list.add(edge);
    }

    public boolean hasEdge(
            T fromVertex,
            T toVertex) {
        
        if (getEdge(fromVertex, toVertex) != null)
            return true;

        return false;
    }

    public Edge<T> getEdge(
            T fromVertex,
            T toVertex) {
        
        // First retrieve the list of all the edges attached to the fromVertex
        List<Edge<T>> list = adjList.get(fromVertex);
        
        if (list == null) {
            return null;
        }
        
        for (Edge edge : list) {
            
            if (edge.)
        }
        
        

        return null;
    }

    public String toString() {
        return null;
    }

}
