package algorithms.graph;


public interface BaseGraph <T> {
    
    public void addVertex(T key);
    
    public void addEdge(T fromVertex, T toVertex);
    
    public boolean hasEdge(T fromVertex, T tovertex);
    
    public Edge<T> getEdge(T fromVertex, T toVertex);
    
    public String toString ();
}
