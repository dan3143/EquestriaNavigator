package graph.data;

/**
 *
 * @author Daniel
 */
public class Edge {

    public Node origin;
    public Node destiny;
    public int weight;

    public Edge(Node origin, Node destiny, int weight) {
        this.origin = origin;
        this.destiny = destiny;
        this.weight = weight;
    }
    
    public Edge inverse(){
        return new Edge(destiny, origin, weight);
    }
}
