package algorithms.ds.graph;

/**
 * This is an interface providing methods form Graph Implementation.
 * 
 */
public interface BaseGraph<E> {

    public void addVertex(
            E key);

    public void addEdge(
            E fromVertex,
            E toVertex, int weight);

    public boolean hasEdge(
            E fromVertex,
            E tovertex);

    public Edge<E> getEdge(
            E fromVertex,
            E toVertex);

    public String toString();
}
