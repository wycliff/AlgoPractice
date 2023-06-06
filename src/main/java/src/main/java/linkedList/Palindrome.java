package src.main.java.linkedList;

public class Palindrome {
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

        System.out.println(isPalindrome(node1));
    }

    static class Node {
        int val;
        Node next = null;

        //Empty Constructor
        Node() {
        }

        public Node(int value) {
            this.val = value;
        }

        Node(int val, Node next) {
            this.val = val;
            this.next = next;
        }
    }

    public static Node reverse(Node head) {
        // initialize
        Node p1 = null; // prev
        Node p2 = head; // curr
        Node p3 = null; // next


      //  1 -> 2  -> 3 -> 4


        while (p2 != null) {
            p3 = p2.next;
            p2.next = p1;
            p1 = p2;
            p2 = p3;
        }
        return p1;
    }

    public static boolean isPalindrome(Node head) {
        if(head==null)
            return false;

        Node first = head;
        Node second = head;


        while (second.next != null && second.next.next != null) {
            first = first.next;
            second = second.next.next;
        }

        second = first; // find center
        first = head;   // reset first to head
        second = reverse(second); // reverse the 2nd half of the list

        //compare values
        while (first != null) {
            if (first.val != second.val)
                return false;
            first = first.next;
            second = second.next;
        }

        return true;
    }
}
