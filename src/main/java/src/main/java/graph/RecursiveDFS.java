package src.main.java.graph;

import java.util.ArrayList;
import java.util.List;

public class RecursiveDFS {
    static class Node {
        String name;
        List<Node> children = new ArrayList<Node>();

        public Node(String name) {
            this.name = name;
        }

        //takes an empty string
        public List<String> depthFirstSearch(List<String> array) {
            array.add(this.name);
            for(int i=0; i < children.size(); i++){
                children.get(i).depthFirstSearch(array);
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
        Node nodeA = new Node("A");
        nodeA.addChild("B");
        nodeA.addChild("C");
        nodeA.addChild("D");


        System.out.println(nodeA.depthFirstSearch(new ArrayList<>()));
    }
}
