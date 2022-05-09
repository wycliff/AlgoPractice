package src.main.java.array;

public class SlidingWindow {

    /***
     * Given an array on n integers find the average of all subarrays of K contiguous elements
     * and return them in a seperate array.
     * Example: [2,1,5,1,3,2] k=3
     * [8/3, 7/3, 9/3, 6,3]
     */

    private double[] subArrayAverage(int[] S, int K) {
        int windowStart = 0;
        int windowEnd = 0;

//        for(int i = 0;  ){
//
//        }

        return new double[]{};
    }


    /***
     * Given an array on n integers find the max sum of all subarrays of K contiguous elements
     * and return them in a seperate array.
     * Example: [2,1,5,1,3,2] k=3
     * soln = 9 from 2+1+5
     */

    private static int subArrayMaxSum(int[] s, int k) {
        int windowStart = 0;
        int windowEnd = 0;
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
        int[] array = {2,1,5,1,3,2};
        System.out.println(subArrayMaxSum(array, 3));
    }
}
