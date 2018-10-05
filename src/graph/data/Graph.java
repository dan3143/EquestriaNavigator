package graph.data;

import graph.graphic.Circle;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class Graph<T> {

    public ArrayList<Node<T>> nodeList;
    public ArrayList<Edge> edgeList;
    public int[][] distances;
    public static final int INF = 999999;
    public static final int RADII = 10;
    public ArrayList<ArrayList<Node<T>>> paths;
    
    public Graph() {
        nodeList = new ArrayList();
        edgeList = new ArrayList();
    }
    
    public static Graph MapOfEquestria(){
        Graph<String> graph = new Graph();
        Node<String> canterlot = new Node("Canterlot", 624, 267);
        Node<String> cloudsdale = new Node("Cloudsdale", 469, 166);
        Node<String> ponyville = new Node("Ponyville", 551, 417);
        Node<String> everfree = new Node("Everfree", 603, 469);
        Node<String> neighagra = new Node("Neighagra Falls", 763, 169);
        Node<String> baltimare = new Node("Baltimare", 1075, 343);
        Node<String> dodge = new Node("Dodge City", 810, 564);
        Node<String> pegasus = new Node("Los Pegasus", 158, 559);
        Node<String> smokey = new Node("Smokey Mountains", 212, 275);
        Node<String> manehattan = new Node("Manehattan", 1236, 231);

        graph.nodeList.add(canterlot);
        graph.nodeList.add(ponyville);
        graph.nodeList.add(cloudsdale);
        graph.nodeList.add(everfree);
        graph.nodeList.add(neighagra);
        graph.nodeList.add(baltimare);
        graph.nodeList.add(dodge);
        graph.nodeList.add(pegasus);
        graph.nodeList.add(smokey);
        graph.nodeList.add(manehattan);
        
        graph.edgeList.add(new Edge(canterlot, ponyville, 5));
        graph.edgeList.add(new Edge(canterlot, neighagra, 10));
        graph.edgeList.add(new Edge(canterlot, manehattan, 60));
        graph.edgeList.add(new Edge(canterlot, cloudsdale, 20));
        graph.edgeList.add(new Edge(canterlot, baltimare, 40));
        graph.edgeList.add(new Edge(canterlot, smokey, 30));
        graph.edgeList.add(new Edge(canterlot, pegasus, 60));
        graph.edgeList.add(new Edge(ponyville, everfree, 10));
        graph.edgeList.add(new Edge(ponyville, cloudsdale, 10));
        graph.edgeList.add(new Edge(everfree, dodge, 20));
        graph.edgeList.add(new Edge(smokey, pegasus, 20));
        graph.edgeList.add(new Edge(baltimare, manehattan, 10));
        graph.edgeList.add(new Edge(baltimare, dodge, 50));
        graph.floydWarshall();
        return graph;
    }
    
    private ArrayList<ArrayList<Node<T>>> initializePaths(){
        ArrayList<ArrayList<Node<T>>> path = new ArrayList();
        Node nullNode = new Node(null);
        for (int i = 0; i < getOrder(); i++) {
            path.add(new ArrayList());
            for (int j = 0; j < getOrder(); j++) {
                path.get(i).add(nullNode);
            }
        }
        return path;
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
    
    public void deleteNode(Node node){
        nodeList.remove(node);
        ArrayList<Edge> edges = new ArrayList<>();
        for (Edge edge : edgeList) {
            if (edge.origin != node && edge.destiny != node){
                edges.add(edge);
            }
        }
        edgeList = edges;
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

    private ArrayList<ArrayList<Node<T>>> generatePathMatrix() {
        ArrayList<ArrayList<Node<T>>> matrix = new ArrayList();
        for (Node<T> node : nodeList) {
            matrix.add(new ArrayList());
        }
        
        for (Node<T> node : nodeList) {
            for (int i = 0; i < nodeList.size(); i++) {
                matrix.get(i).add(node);
            }
        }
        
        return matrix;
    }

    public void floydWarshall() {
        distances = generateDistanceMatrix();
        paths = generatePathMatrix();
        int n = distances.length;
        for (int k = 0; k < n; k++) {
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (distances[i][j] != 0) {
                        if ((distances[i][k] + distances[k][j]) < distances[i][j]) {
                            distances[i][j] = distances[i][k] + distances[k][j];
                            paths.get(i).set(j, nodeList.get(k));
                        }
                    }
                }
            }
        }
        showMatrices();
    }
     void showMatrices() {
        System.out.println("\nDistancias:");
        for (int i = 0; i < distances.length; i++) {
            System.out.println(Arrays.toString(distances[i]));
        }
        if (paths == null) {
            return;
        }
        System.out.println("Caminos:");
        for (ArrayList<Node<T>> camino : paths) {
            for (Node<T> node : camino) {
                if (node == null) {
                    break;
                }
                System.out.print(node.toString() + ", ");
            }
            System.out.println();
        }

    }

    public int nodeIndex(T info) {
        int i;
        for (i = 0; i < nodeList.size(); i++) {
            if (nodeList.get(i).info.equals(info)) {
                return i;
            }
        }
        return -1;
    }
    
    public Node<T> getNodeAt(double x, double y){
        for (Node<T> node : nodeList) {
            if (node.contains(x, y)) return node;
        }
        return null;
    }
    
    public Stack<Node<T>> getPath(Node u, Node v){
        int j = nodeList.indexOf(v);
        int i = nodeList.indexOf(u);
        Stack<Node<T>> path = new Stack();
        path.add(v);
        Node aux = paths.get(i).get(j);
        while (aux != nodeList.get(j)){
            path.push(aux);
            j = nodeList.indexOf(aux);
            aux = paths.get(i).get(j);
        }
        path.push(u);
        return path;
    }

}
