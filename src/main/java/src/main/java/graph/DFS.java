package src.main.java.graph;

import java.util.*;

public class DFS {
    public static List<Integer> dfs(MyGraph testGraph, int source) {

        List<Integer> output = new ArrayList();

        if(testGraph==null){
            return output;
        }

        //initialize stack
        Stack<Integer> dfsStack = new Stack();
        boolean boolArray[] = new boolean[testGraph.getVertices()];

        //Mark visited and enqueue
        boolArray[source] = true;
        dfsStack.push(source);

        while (!dfsStack.isEmpty()) {
            Integer currNode = dfsStack.pop();
            output.add(currNode);

            List<Integer> adjacencyList = testGraph.adjacencyList[currNode];

            if (adjacencyList == null) {
                continue;
            }

            //A java cursor used to traverse a list i.e ArrayList, Vector, LinkedList, Stack
            ListIterator<Integer> adjacencyIterator = adjacencyList.listIterator();

            while (adjacencyIterator.hasNext()) {
                int temp = adjacencyIterator.next();
                System.out.println("iterator return: "+ temp);

                //Is the vertex visited
                if (!boolArray[temp]) {
                    boolArray[temp] = true;
                    dfsStack.push(temp);
                }
            }
        }

        return output;
    }

    public static void main(String[] args) {
        MyGraph testGraph = new MyGraph(5);
        testGraph.addEdge(0, 1);
        testGraph.addEdge(0, 2);

        testGraph.addEdge(1, 3);
        testGraph.addEdge(1, 4);

        System.out.println(dfs(testGraph, 0));
    }
}
