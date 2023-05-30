package src.main.java.linkedList;

class SumLinkedLists {
    public static class LinkedList {
        public int value;
        public LinkedList next;

        public LinkedList(int value) {
            this.value = value;
            this.next = null;
        }
    }

    public static LinkedList sumOfLinkedLists(LinkedList linkedListOne, LinkedList linkedListTwo) {
        //https://www.algoexpert.io/questions/find-loop
        // Write your code here.: without hint
        int num1 = 0;
        int num2 = 0;
        int exp1 = 1;
        int exp2 = 1;

        while (linkedListOne != null) {
            num1 += (linkedListOne.value * exp1);
            exp1 *= 10;
            linkedListOne = linkedListOne.next;
        }

        while (linkedListTwo != null) {
            num2 += (linkedListTwo.value * exp2);
            exp2 *= 10;
            linkedListTwo = linkedListTwo.next;
        }

        int sum = num1 + num2;

        LinkedList prev, head;
        LinkedList curr = null;

        //Keep track of head
        int val = sum % 10;
        head = new LinkedList(val);
        sum /= 10;
        prev = head;

        while (sum % 10 != 0) {
            int val2 = sum % 10;
            curr = new LinkedList(val2);
            prev.next = curr;

            sum /= 10;
            prev = curr;
        }

        while (head != null) {
            System.out.println(head.value);
            head = head.next;
        }
        return head;
    }


    //solution2
    public static LinkedList sumOfLinkedLists2(LinkedList linkedListOne, LinkedList linkedListTwo) {

        LinkedList prev, head;
        LinkedList curr = null;

        //Keep track of head
        head = new LinkedList(0);
        prev = head;
        int curry = 0;

        while (linkedListOne != null || linkedListTwo != null) {
            int val;

            if(linkedListOne != null && linkedListTwo != null) {
                val = (linkedListOne.value + linkedListTwo.value + curry) % 10;
                curry = (linkedListOne.value + linkedListTwo.value + curry) / 10;
            }else if(linkedListOne != null && linkedListTwo == null){
                val = (linkedListOne.value + curry) % 10;
                curry = (linkedListOne.value + curry) / 10;
            }else{
                val = ( linkedListTwo.value + curry) % 10;
                curry = (linkedListTwo.value + curry) / 10;
            }

            //add new node
            curr = new LinkedList(val);
            prev.next = curr;
            prev = curr;

            //increment
            LinkedList temp = new LinkedList(0);

            if (linkedListOne!= null && linkedListTwo!= null) {
                linkedListOne = linkedListOne.next;
                linkedListTwo = linkedListTwo.next;
            } else if (linkedListOne != null && linkedListTwo == null) {
                linkedListOne = linkedListOne.next;
                linkedListTwo = temp;
            } else if (linkedListOne == null && linkedListTwo != null) {
                linkedListOne = temp;
                linkedListTwo = linkedListTwo.next;
            }else{
                if (curry > 0) {
                    linkedListOne = temp;
                    linkedListTwo = temp;
                }else{
                    linkedListOne = null;
                    linkedListTwo = null;
                }
            }
        }

        return head.next;

    }


    public static void main(String[] args) {
        //LinkedList1
        LinkedList node4 = new LinkedList(1);
        node4.next = null;
        LinkedList node3 = new LinkedList(7);
        node3.next = node4;
        LinkedList node2 = new LinkedList(4);
        node2.next = node3;
        LinkedList node1 = new LinkedList(2);
        node1.next = node2;

        //LinkedList2
        LinkedList node7 = new LinkedList(5);
        node7.next = null;
        LinkedList node6 = new LinkedList(4);
        node6.next = node7;
        LinkedList node5 = new LinkedList(9);
        node5.next = node6;

        sumOfLinkedLists2(node1, node5);
    }
}