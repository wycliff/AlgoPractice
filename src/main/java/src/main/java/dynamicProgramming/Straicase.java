package src.main.java.dynamicProgramming;

public class Straicase {

    //top down: recursive O(3^n)
    public static int ascend(int hop, int n) {
        int count = 0;
        n = n - hop;
        if (n == 0) {
            return 1;
        } else if (n < 1) {
            return 0;
        } else {
            count += ascend(1, n) + ascend(2, n) + ascend(3, n);
        }

        return count;
    }

    //Memoise ascend
    public static int ascendMemo(int hop, int n, int[] memo) {

        //decrease n each time
        n = n - hop;

        if (n < 0) {
            return 0;
        } else if (n == 0) {
            memo[0] = 1;
            return memo[0];
        } else{
           memo[n]= ascendMemo(1, n,memo) + ascendMemo(2, n,memo) + ascendMemo(3, n, memo);
        }

        return memo[n];
    }

    public static void main(String args[]) {
        int n = 4;
        int[] memo = new int[n+1];
        System.out.println(ascend(0, n));
        System.out.println(ascendMemo(0, n, memo));
    }
}


//This week:
//Dynamic programming
//Searching & Sorting
//Stacks
//Queues (heaps)
//Graphs
//Linked lists