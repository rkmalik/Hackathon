package algorithms.graph;

/**
 * This class holds information about a particular node in the graph. Each node contains data information.
 * 
 */
public class Vertex<T> {

    private T data;
    private boolean isVisited;
    

    public Vertex(
            T data) {
        this.data = data;
        this.isVisited = false;
    }
    
    public void setVisited(boolean isVisited) {
        this.isVisited = isVisited;
    }
    
    public boolean isVisited() {
        return this.isVisited;
    }
    
    public String toString() {
        return "Node " + data;
    }
}
