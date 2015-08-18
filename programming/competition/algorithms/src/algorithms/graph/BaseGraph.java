package algorithms.graph;

/**
 * This is an interface providing methods form Graph Implementation.
 * 
 */
public interface BaseGraph<T> {

    public void addVertex(
            T key);

    public void addEdge(
            T fromVertex,
            T toVertex, int weight);

    public boolean hasEdge(
            T fromVertex,
            T tovertex);

    public Edge<T> getEdge(
            T fromVertex,
            T toVertex);

    public String toString();
}
