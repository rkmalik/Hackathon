package a_graph;

import java.util.LinkedList;

import a_graph_Implementation.Edge;
import a_graph_Implementation.RGraph;
import a_graph_Implementation.Vertex;

public class GraphHandler {

	public static void main(String args[]) {

		RGraph<Integer> graph = new RGraph<>();
		buildGraph(graph, 10);
		Vertex <Integer> root = graph.getVertex(1);
		/*graph.resetVertices();
		depthFirstSearchTraversal(graph, root);*/
		graph.resetVertices();
		breadthFirstSearchTraversal (graph, root);
		
	}

	public static void buildGraph(RGraph<Integer> graph, int vertices) {

		// graph.addEdge(fromVertex, toVertex);
		graph.addEdge(1,12);
		graph.addEdge(1,10);
		graph.addEdge(1,7);
		graph.addEdge(1,21);
		graph.addEdge(7,21);
		graph.addEdge(10,21);
		graph.addEdge(21, 31);
		graph.addEdge(21, 14);
		graph.addEdge(14,14);
		
		System.out.println("Built the graph");
	}
	
	public static void depthFirstSearchTraversal(RGraph<Integer> graph, Vertex<Integer> root) {
		
		if (root == null)
			return;
		
		LinkedList<Edge<Integer>> list = graph.getAdjList(root.getData());
		root.visited(true);
		System.out.println("Visited : " + root.getData());
		
		for (Edge<Integer> e : list) {
			if (e.getToVertex().isVisited()==false)
			depthFirstSearchTraversal(graph, e.getToVertex());
		}
	}
	
	public static void breadthFirstSearchTraversal(RGraph<Integer> graph, Vertex<Integer> root) {
		
		if (root == null)
			return;

		//root.visited(true);
		LinkedList<Vertex<Integer>> queue = new LinkedList<>();
		queue.addLast(root);
		root.visited(true);
		System.out.println("Visited : "+  root.getData());
		while(queue.isEmpty()==false) {
			Vertex<Integer> v = queue.removeFirst();
			LinkedList<Edge<Integer>> list = graph.getAdjList(v.getData());
			for (Edge<Integer> e: list) {
				if (e.getToVertex().isVisited()==false) {
					System.out.println("Visited : " + e.getToVertex().getData());
					e.getToVertex().visited(true);
					queue.addLast(e.getToVertex());
				}
			}
		}
	}

}
