package src.main.java.linkedList;


public class LoopLinkedList {
    public static void main(String[] args) {
        // write your code here

        Node node9 = new Node(9,null);
        Node node8 = new Node(8,node9);
        Node node7 = new Node(7,node8);
        Node node6 = new Node(6,node7);
        Node node5 = new Node(5,node6);
        Node node4 = new Node(4,node5);
        Node node3 = new Node(3,node4);
        Node node2 = new Node(2,node3);
        Node node1 = new Node(1,node2);
        node9.next = node5; // loop

        System.out.println(findLoop(node1).val);

    }

    static class Node {
        int val;
        Node next = null;

        //Empty Constructor
        Node() {
        }

        public Node(int value){
            this.val = value;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    //Detects the node where the loop starts
    public static Node findLoop(Node head){
        Node first = head.next;
        Node second = head.next.next;

        while(first != second){
            first = first.next;
            second = second.next.next;
        }
        first = head;

        while(first != second){
            first = first.next;
            second = second.next;
        }
        return first;
    }
}
