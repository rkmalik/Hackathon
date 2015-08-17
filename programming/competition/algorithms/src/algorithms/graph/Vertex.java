package algorithms.graph;

/**
 * This class holds information about a particular node in the graph. 
 * Each node contains data information.
 * 
 * */
public class Vertex<T> {
    
    private T data;
    
    public Vertex (T data) {
        this.data = data;
    }
    
    public String toString () {
        return "Node " + data;
    }
}
