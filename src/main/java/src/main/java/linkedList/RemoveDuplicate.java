package src.main.java.linkedList;

import java.util.HashMap;

public class RemoveDuplicate {
    static class Node {
        int val;
        Node next = null;

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    private static Node removeDuplicate(Node head) {
        if (head == null)
            return null;

        //put first element in the hash
        HashMap<Integer, Boolean> map = new HashMap();
        map.put(head.val, true);
        Node prev = head;
        Node current = head.next;

        while (current.next != null) {
            if(map.containsKey(current.val)){
                removeElement(prev);
            }else{
                map.put(current.val, true);
            }
            prev = current;
            current = current.next;
        }

        return head;
    }

    private static void removeElement(Node prev) {
        prev.next = prev.next.next;
    }

    public static void main(String[] args) {
        Node node9 = new Node(1, null);
        Node node8 = new Node(2, node9);
        Node node7 = new Node(3, node8);
        Node node6 = new Node(4, node7);
        Node node5 = new Node(5, node6);
        Node node4 = new Node(4, node5);
        Node node3 = new Node(3, node4);
        Node node2 = new Node(2, node3);
        Node node1 = new Node(1, node2);

        Node n= removeDuplicate(node1);

        while(n.next != null){
            System.out.println(n.val);
            n = n.next;
        }
    }
}
