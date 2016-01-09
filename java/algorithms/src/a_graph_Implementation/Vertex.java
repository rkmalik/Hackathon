package a_graph_Implementation;

public class Vertex <E>{
	
	private boolean visited;
	private E data;
	
	public Vertex (E data) {
		this.data = data;
		this.visited = false;
	}
	
	public boolean isVisited () {
		return visited;
	}
	
	public E getData() {
		return data;
	}
	
	public void visited (boolean visit) {
		this.visited = visit;
	}
}
