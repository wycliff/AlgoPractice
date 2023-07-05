package src.main.java.mock;

public class Solution2 {

    public static int subArrayMax(int[] arr) {
        //loop through array
        //start with window - 1,2,3,4
        // sum -> max
        // 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4
        int maxSum = Integer.MIN_VALUE;

        for (int i = 0; i < arr.length; i++) {
            int winSize = 1;
            while ((i + winSize) < arr.length) {
                int temp = subArraySum(arr, i, i + winSize);
                maxSum = Math.max(maxSum, temp);
                winSize++;
            }
        }
        return maxSum;
    }

    public static int subArraySum(int[] arr, int start, int end) {
        int tempSum = 0;
        for (int j = start; j <= end; j++) {
            tempSum += arr[j];
        }
        return tempSum;
    }

    public static int subArrayMaxKadane(int[] arr) {
        //loop through array
        //start with window - 1,2,3,4
        // sum -> max
        // 3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4
        // 3, 8, 0, 1, 4, 2, 5, 9, 16, 18, 9, 15, 18, 19, 14, 18
        // kadane's algorithm
        int maxSoFar = Integer.MIN_VALUE;
        int maxEndingHere = 0;

        for (int i = 0; i < arr.length; i++) {
            maxEndingHere = maxEndingHere + arr[i];
            if(maxSoFar < maxEndingHere){
                maxSoFar = maxEndingHere;
            }
            if(maxEndingHere < 0){
                maxEndingHere = 0;
            }
        }
        return maxSoFar;
    }



    //prefix sum technique


    public static void main(String[] Args) {
        int [] arr = {3, 5, -9, 1, 3, -2, 3, 4, 7, 2, -9, 6, 3, 1, -5, 4};
        System.out.println(subArrayMaxKadane(arr));  //n^3
    }
}
