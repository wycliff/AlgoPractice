package src.main.java.graph;

import java.util.*;

public class BFS {
    public static  List<Integer> bfs(MyGraph testGraph, int source) {

        List<Integer> output = new ArrayList();

        if(testGraph==null){
            return output;
        }

        //Initialize queue
        Queue<Integer> bfsQueue = new LinkedList<>();
        boolean boolArray[] = new boolean[testGraph.getVertices()];

        //Mark visited and enqueue
        boolArray[source] = true;
        bfsQueue.add(source);

        while (!bfsQueue.isEmpty()) {
            Integer currNode = bfsQueue.poll();
            output.add(currNode);

            List<Integer> adjacencyList = testGraph.adjacencyList[currNode];

            if (adjacencyList == null) {
                continue;
            }

            //A java cursor used to traverse a list i.e ArrayList, Vector, LinkedList, Stack
            ListIterator<Integer> adjacencyIterator = adjacencyList.listIterator();

            while (adjacencyIterator.hasNext()) {
                int temp = adjacencyIterator.next();
                //Is the vertex visited
                if (!boolArray[temp]) {
                    boolArray[temp] = true;
                    bfsQueue.add(temp);
                }
            }

            //or
//            for (int temp : adjacencyList) {
//                //Is the vertex visited
//                if (!boolArray[temp]) {
//                    boolArray[temp] = true;
//                    bfsQueue.add(temp);
//                }
//            }
        }
        return output;
    }

    public static void main(String[] args) {
        MyGraph testGraph = new MyGraph(5);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);

        testGraph.addEdge(1, 3);
        testGraph.addEdge(1, 4);
     //   testGraph.addEdge(2, 4);


        //Step throughs
        boolean boolArray[] = new boolean[testGraph.getVertices()];
        for (int i = 0; i < testGraph.adjacencyList.length; i++) {
            System.out.println(testGraph.adjacencyList[i]);
            System.out.println(boolArray[i]);
        }

        System.out.println(bfs(testGraph, 0));
    }
}
