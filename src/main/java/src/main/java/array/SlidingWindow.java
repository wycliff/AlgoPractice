package src.main.java.array;

import java.util.*;

public class SlidingWindow {

    /***
     * Dynamic programming
     * Given an array on n integers find the average of all subarrays of K contiguous elements
     * and return them in a seperate array.
     * Example: [2,1,5,1,3,2] k=3
     * [8/3, 7/3, 9/3, 6,3]
     * @return
     */

    private static Double[] subArrayAverage(int[] S, int K) {
        int windowStart = 0;
        List<Double> output = new ArrayList<>();

        for (int i = windowStart; i < S.length - K + 1; i++) {
            int windowSum = 0;
            for (int j = 0; j < K; j++) {
                windowSum = windowSum + S[i+j];
            }
            double average = windowSum/3d;
            output.add(average);
        }

        //Convert list to double
        Double[] doubleArray = new Double[output.size()];
        output.toArray(doubleArray);

        return doubleArray;
    }


    /***
     * Given an array on n integers find the max sum of all subarrays of K contiguous elements
     * and return them in a seperate array.
     * Example: [2,1,5,1,3,2] k=3
     * soln = 9 from
     * 5+1+3
     */

    private static int subArrayMaxSum(int[] s, int k) {
        int maxSum = Integer.MIN_VALUE;

        // Consider all blocks starting with i.
        for (int i = 0; i < s.length - k + 1; i++) {
            int current_sum = 0;
            for (int j = 0; j < k; j++)
                current_sum = current_sum + s[i + j];

            // Update result if required.
            maxSum = Math.max(current_sum, maxSum);
        }
        return maxSum;
    }




    public static void main(String[] args) {
        int[] array = {1,3,6,4,1,2};
        System.out.println(subArrayMaxSum(array, 3));
        System.out.println(subArrayAverage(array, 3));
    }
}
