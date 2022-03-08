package src.main.java.graph;

import java.util.*;

public class TopologicalSort {
    public static void topologicalSort(MyGraph testGraph) {
        int v = testGraph.adjacencyList.length;

        // Create an array to store in-degrees of all vertices. Initialize all in-degrees as 0.
        int indegree[] = new int[v];

        // Traverse adjacency lists to fill indegrees of vertices. This step takes O(V+E) time
        for (int i = 0; i < v; i++) {
            ArrayList<Integer> temp =new ArrayList<>(testGraph.adjacencyList[i]);
            for (int node : temp) {
                indegree[node]++;
            }
        }

        // Create a queue and enqueue all vertices with indegree 0
        Queue<Integer> q = new LinkedList<Integer>();
        for (int i = 0; i < v; i++) {
            if (indegree[i] == 0)
                q.add(i);
        }

        // Initialize count of visited vertices
        int cnt = 0;

        // Create a vector to store result (A topological ordering of the vertices)
        Vector<Integer> topOrder = new Vector<Integer>();
        while (!q.isEmpty()) {
            // Extract front of queue (or perform dequeue) and add it to topological order
            int u = q.poll();
            topOrder.add(u);

            // Iterate through all it neighbouring nodes of dequeued node u and decrease their in-degree by 1
            for (int node : testGraph.adjacencyList[u]) {
                // If in-degree becomes zero, add it to queue
                if (--indegree[node] == 0)
                    q.add(node);
            }
            cnt++;
        }

        // Check if there was a cycle
        if (cnt != v) {
            System.out.println(
                    "There exists a cycle in the graph");
            return;
        }

        // Print topological order
        for (int i : topOrder) {
            System.out.print(i + " ");
        }
    }

    public static void main(String[] args) {
        MyGraph testGraph = new MyGraph(4);
        testGraph.addEdge(3, 2);
        testGraph.addEdge(3, 0);

        testGraph.addEdge(2, 0);
        testGraph.addEdge(2, 1);

        topologicalSort(testGraph);
    }
}
