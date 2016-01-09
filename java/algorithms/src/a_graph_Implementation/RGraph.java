package a_graph_Implementation;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map.Entry;

public class RGraph<E> implements BaseGraph<E> {

	private HashMap<E, LinkedList<Edge<E>>> adjlist;
	private HashMap<E, Vertex<E>> vertices;
	private boolean isDirected;

	public RGraph(boolean isDirectedGraph) {
		adjlist = new HashMap<E, LinkedList<Edge<E>>>();
		vertices = new HashMap<E, Vertex<E>>();
		this.isDirected = isDirectedGraph;
	}

	public RGraph() {
		adjlist = new HashMap<E, LinkedList<Edge<E>>>();
		vertices = new HashMap<E, Vertex<E>>();
		this.isDirected = false;
	}

	@Override
	public void addEdge(E fromVertex, E toVertex) {
		Vertex<E> from = addVertex(fromVertex);
		Vertex<E> to = addVertex(toVertex);

		if (isDirected == false) {

			LinkedList<Edge<E>> list;
			if (adjlist.containsKey(toVertex) == true) {
				list = adjlist.get(toVertex);
			} else {
				list = new LinkedList<>();
				adjlist.put(toVertex, list);
			}
			Edge<E> edge = new Edge<E>(to, from);
			list.add(edge);
		}

		LinkedList<Edge<E>> list;
		if (adjlist.containsKey(fromVertex) == true) {
			list = adjlist.get(fromVertex);
		} else {
			list = new LinkedList<>();
			adjlist.put(fromVertex, list);
		}
		Edge<E> edge = new Edge<E>(from, to);
		list.add(edge);
	}

	@Override
	public Vertex<E> addVertex(E vertex) {
		Vertex<E> from = null;
		if (vertices.containsKey(vertex) == false) {
			from = new Vertex<E>(vertex);
			vertices.put(vertex, from);
		} else {
			from = vertices.get(vertex);
		}
		return from;
	}

	@Override
	public boolean hasEdge(E fromVertex, E toVertex) {

		if (!adjlist.containsKey(fromVertex) || !adjlist.containsKey(toVertex))
			return false;
		LinkedList<Edge<E>> edges = adjlist.get(fromVertex);

		for (Edge<E> v : edges) {
			if (v.getToVertex().equals(toVertex))
				return true;
		}
		return false;
	}

	@Override
	public Edge<E> getEdge(E fromVertex, E toVertex) {
		if (!adjlist.containsKey(fromVertex) || !adjlist.containsKey(toVertex))
			return null;

		LinkedList<Edge<E>> edges = adjlist.get(fromVertex);

		for (Edge<E> e : edges) {
			if (e.getToVertex().equals(toVertex))
				return e;
		}

		return null;
	}

	public Vertex<E> getVertex(E vertex) {

		if (vertices.containsKey(vertex))
			return vertices.get(vertex);

		return null;
	}

	public LinkedList<Edge<E>> getAdjList(E vertex) {

		if (adjlist.containsKey(vertex))
			return adjlist.get(vertex);

		return null;
	}

	public void resetVertices() {

		for (Entry<E, Vertex<E>> entry : vertices.entrySet()) {
			entry.getValue().visited(false);
		}
	}

}
