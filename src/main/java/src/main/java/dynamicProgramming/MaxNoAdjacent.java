package src.main.java.dynamicProgramming;

public class MaxNoAdjacent {

    /***
     * Dynamic programming : Array
     * Given an array on n integers find the max sum of non-adjacent integers
     * return 0 if the array is empty
     * Example: [75, 105, 120, 75, 90, 135]
     * Solution :  330  = 75 + 120 + 135
     */
    public static int maxSubsetSumNoAdjacent(int[] array) {
        if (array.length < 1) {
            return 0;
        }
        if(array.length == 1){
            return array[0];
        }

        int[] sumArray = new int[array.length];

        for (int i = 0; i < array.length; i++) {
            int currMax = 0;
            if (i > 1) {
                currMax = sumArray[i - 2] + array[i];
                sumArray[i - 1] = Math.max(sumArray[i - 2], sumArray[i - 1]);
            } else {
                currMax = array[i];
            }
            sumArray[i] = currMax;
        }
        return Math.max(sumArray[array.length - 1], sumArray[array.length - 2]);
        // return sumArray[array.length-1];
    }


    public static void main(String[] args) {
        int[] array = {75, 105, 120, 75, 90, 135};
        System.out.println((maxSubsetSumNoAdjacent(array)));
    }
}

