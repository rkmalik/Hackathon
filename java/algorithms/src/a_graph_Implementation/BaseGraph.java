package a_graph_Implementation;

public interface BaseGraph <E> {
	public void addEdge (E fromVertex, E toVertex);
	public Vertex<E> addVertex (E vertex);
	public boolean hasEdge (E fromVertex, E toVertex);
	public Edge <E> getEdge (E fromVertex, E toVertex);
}
