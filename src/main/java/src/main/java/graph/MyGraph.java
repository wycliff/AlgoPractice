package src.main.java.graph;


import java.util.LinkedList;
import java.util.List;


public class MyGraph {
    List<Integer> adjacencyList[];
    int vertices;

    public MyGraph(int vertices) {
        this.vertices = vertices;
        this.adjacencyList = new List[vertices];

        for (int i = 0; i < vertices; i++) {
            this.adjacencyList[i] = new LinkedList<>();
        }
    }

    public void addEdge(int source, int destination) {
        this.adjacencyList[source].add(destination);
    }

    public int getVertices() {
        return this.vertices;
    }
}