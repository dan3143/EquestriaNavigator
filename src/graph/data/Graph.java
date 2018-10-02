package graph.data;

import graphlab.graphic.Circle;
import java.util.LinkedList;

public class Graph<T> {

    public final LinkedList<Node<T>> nodeList;
    public final LinkedList<Edge> edgeList;
    public int[][] distances;
    public String[][] paths;
    public static final int INF = 9999;

    public Graph() {
        nodeList = new LinkedList();
        edgeList = new LinkedList();
    }

    public boolean contains(T info) {
        for (Node<T> node : nodeList) {
            if (node.info.equals(info)) {
                return true;
            }
        }
        return false;
    }

    public void addNode(Node<T> node) {
        nodeList.add(node);
    }

    public int getOrder() {
        return nodeList.size();
    }

    public int getSize() {
        return edgeList.size();
    }

    public Node<T> getNode(int index) {
        return nodeList.get(index);
    }

    public boolean isOccupied(Circle circle) {
        for (Node<T> node : nodeList) {
            if (node.intersects(circle)) {
                return true;
            }
        }
        return false;
    }

    public void connectNode(Node<T> node1, Node<T> node2, int weight) {
        edgeList.add(new Edge(node1, node2, weight));
    }

    private int[][] generateDistanceMatrix() {
        int matrix[][] = new int[nodeList.size()][nodeList.size()];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (i == j) {
                    matrix[i][j] = 0;
                } else {
                    matrix[i][j] = INF;
                }
            }
        }
        for (Edge edge : edgeList) {
            matrix[nodeList.indexOf(edge.origin)][nodeList.indexOf(edge.destiny)] = edge.weight;
        }
        return matrix;
    }

    private String[][] generatePathMatrix() {
        String matrix[][] = new String[nodeList.size()][nodeList.size()];
        for (int j = 0; j < matrix.length; j++) {
            String element = nodeList.get(j).info.toString();
            for (int i = 0; i < matrix.length; i++) {
                matrix[i][j] = element;
            }
        }
        return matrix;
    }

    public void floydWarshall() {
        distances = generateDistanceMatrix();
        paths = generatePathMatrix();
        int n = distances.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                for (int k = 0; k < n; k++) {
                    if (distances[i][j] != 0) {
                        if ((distances[i][k] + distances[k][j]) < distances[i][j]) {
                            distances[i][j] = distances[i][k] + distances[k][j];
                            paths[i][j] = nodeList.get(k).info.toString();
                        }
                    }
                }
            }
        }
    }

}
