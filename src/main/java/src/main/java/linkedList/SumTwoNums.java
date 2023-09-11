package src.main.java.linkedList;


import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class SumTwoNums {
    public static List<Integer> addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode llSoln = new ListNode();

        List<Integer> soln = new ArrayList<>();

        int carry = 0;
        while(l1.next!=null || l2!=null){
            int sum = l1.val + l2.val;

            if(l1.next!=null){
                l1 = l1.next;
            }
            if(l2.next!=null){
                l2 = l2.next;
            }
            carry = sum/10;
            int sumVal = sum % 10;
            soln.add(sumVal + carry);

        }
        Collections.reverse(soln);
        return soln;
    }

    public static class ListNode {
        int val;
        SumTwoNums.ListNode next;

        //empty constructor
        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, SumTwoNums.ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    public static void main(String[] args) {
        //LinkedList1
        ListNode node3 = new ListNode(3);
        node3.next = null;
        ListNode node2 = new ListNode(4);
        node2.next = node3;
        ListNode node1 = new ListNode(2);
        node1.next = node2;



        //LinkedList2
        ListNode node6 = new ListNode(5);
        node1.next = null;
        ListNode node5 = new ListNode(6);
        node2.next = node6;
        ListNode node4 = new ListNode(4);
        node3.next = node5;

        System.out.println(addTwoNumbers(node1,node2));
    }
}

