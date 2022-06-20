package src.main.java.graph;


import java.util.*;

class BFS2 {
    // Do not edit the class below except
    // for the breadthFirstSearch method.
    // Feel free to add new properties
    // and methods to the class.
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        public List<String> breadthFirstSearch(List<String> array) {
            Queue<Node> bfsQueue = new LinkedList<>();
            bfsQueue.add(this);

            while (!bfsQueue.isEmpty()) {
                Node source = bfsQueue.poll();
                array.add(source.name);

                if (source.children.size() == 0) {
                    continue;
                }
                bfsQueue.addAll(source.children);
            }

            return array;
        }

        public Node addChild(String name) {
            Node child = new Node(name);
            children.add(child);
            return this;
        }
    }

    public static void main(String[] args) {
        BFS2.Node nodeA = new BFS2.Node("A");
        nodeA.addChild("B");
        nodeA.addChild("C");
        nodeA.addChild("D");


        System.out.println(nodeA.breadthFirstSearch(new ArrayList<>()));
    }
}
