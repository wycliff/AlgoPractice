package src.main.java.greedyAlgorithms;

import java.util.Arrays;

public class MinimumWaitingTime {
    public static int minimumWaitingTime(int[] queries) {
        // Write your code here.
        Arrays.sort(queries);
        int waitingTime = 0;
        int totalWaitingTime = 0;

        waitingTime += queries[0];

        for (int i = 1; i < queries.length; ++i) {
            totalWaitingTime += waitingTime;
            waitingTime += queries[i];
        }

        return totalWaitingTime;
    }

    public static void main(String[] args) {
        int[] array = {3, 2, 1, 2, 6};
        System.out.println(minimumWaitingTime(array));
    }
}
