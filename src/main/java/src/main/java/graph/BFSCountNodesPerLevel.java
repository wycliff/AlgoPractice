package src.main.java.graph;

import java.util.*;

public class BFSCountNodesPerLevel {

    public static List<Integer> bfsCount(MyGraph testGraph, int source) {

        List<Integer> output = new ArrayList();
        if (testGraph == null) {
            return output;
        }

        //Initialize queue
        Queue<Integer> bfsQueue = new LinkedList<>();
        Integer visited[] = new Integer[testGraph.getVertices()];

        for (int i = 0; i < testGraph.adjacencyList.length; i++) {
            visited[i] = 0;
        }

        int level = 1;

        //Mark visited and enqueue
        visited[source] = level;
        bfsQueue.add(source);

        while (!bfsQueue.isEmpty()) {
            Integer currNode = bfsQueue.poll();
            output.add(visited[currNode]);

            List<Integer> adjacencyList = testGraph.adjacencyList[currNode];
            if (adjacencyList == null) {
                continue;
            }

            //A java cursor used to traverse a list i.e ArrayList, Vector, LinkedList, Stack
            ListIterator<Integer> adjacencyIterator = adjacencyList.listIterator();

            while (adjacencyIterator.hasNext()) {
                int temp = adjacencyIterator.next();

                //Is the vertex visited
                if (visited[temp] < level) {
                    visited[temp] = level + 1;
                    bfsQueue.add(temp);
                }
            }
            level += 1;
        }
        return output;
    }


    public static void main(String[] args) {
        MyGraph testGraph = new MyGraph(5);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);

        testGraph.addEdge(1, 3);
        testGraph.addEdge(1, 4);

        //list of counts
        System.out.println(bfsCount(testGraph, 0));

        //Summarize the data : Approach 1
        HashMap<Integer, Integer> summary = new HashMap<>();
        List<Integer> adjacencyList = bfsCount(testGraph, 0);

        for (int i = 0; i < adjacencyList.size()-1; i++) {
            if (summary.containsKey(i)) {
                summary.put(i, summary.get(i) + 1);
            }

            if (!summary.containsKey(i)) {
                summary.put(i, adjacencyList.get(i));
            }
        }
        System.out.println(summary.values());


        //Summarize the data : Approach 2
//        for (int i = 0; i < adjacencyList.size(); i++) {
//            adjacencyList.getOrDefault(index, "defaultValue");
//        }
    }
}
