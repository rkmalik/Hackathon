package a_graph_Implementation;

public class Edge <E> {
	private Vertex<E> fromVertex;
	private Vertex<E> toVertex;
	private int weight;
	
	public Edge (Vertex<E> fromVertex, Vertex<E> toVertex) {
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.weight = 1;
	}

	public Edge (Vertex<E> fromVertex, Vertex<E> toVertex, int weight) {
		this.fromVertex = fromVertex;
		this.toVertex = toVertex;
		this.weight = weight;
	}
	
	public Vertex<E> getFromVertex() {
		return fromVertex;
	}
	
	public Vertex<E> getToVertex () {
		return toVertex;
	}
	
	public int getWeight() {
		return weight;
	}
}
