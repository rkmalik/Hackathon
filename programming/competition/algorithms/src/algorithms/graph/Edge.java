package algorithms.graph;

import org.apache.commons.lang3.Validate;

/**
 * Edge class holds the information about the starting of the edge and ending of the edge. That means it holds from
 * vertex and to vertex information. If this is a weighted graph, then this also holds the weight information. This is a
 * template based class can hold any type of data.
 * 
 */
public class Edge<T> {

    private T fromVertex;
    private T toVertex;
    private int weight;

    public Edge(
            T fromVertex,
            T toVertex,
            int weight) {

        /**
         * None of the vertices can not be null
         */
        Validate.notNull(fromVertex, "from Vertex can not be ", fromVertex);
        Validate.notNull(toVertex, "to Vertex can not be ", toVertex);

        this.fromVertex = fromVertex;
        this.toVertex = toVertex;
        this.weight = weight;
    }
    
    public T getFromVertex() {
        return fromVertex;
    }

    public T getToVertex() {
        return toVertex;
    }
    
    public int getWeight() {
        return weight;
    }

    public String toString() {
        return "Edge from " + fromVertex + " to " + toVertex + " with weight " + weight + ".";
    }
}
