package src.main.java.array;

import java.util.HashMap;
import java.util.HashSet;

/*
* Given a non-empty array of distinct integers, find all possible pairs that add up to a given target sum.
* Constraints : can't add a number to itself to get the sum.
* If no 2 ints sum up to the target, return an empty array. (Assume there is at most one pair summing up to the target sum.
* */

public class TwoNumberSum {
    public static void main(String[] args) {
        int[] array = {3, 5, -4, 8, 11, 1, -1, 6};// {4,6,1} - 5;
        int[] soln = twoNumberSum(array, 10);
        for (int i = 0; i < soln.length; i++)
            System.out.println(soln[i]);
    }

    public static int[] twoNumberSum(int[] array, int targetSum) {

        //Hint 1 : brute O(n^2)
//        for (int i = 0; i < array.length; i++) {
//            for (int j = i; j < array.length; j++) {
//                if ((array[i] + array[j]) == targetSum && (array[i] != array[j])) {
//                    return new int[]{array[i], array[j]};
//                }
//            }
//        }

        //Hint 2 Approach O(n) : using a HashSet
//        HashSet<Integer> arrHash = new HashSet<>();
//        for (int value : array) {
//            if (!arrHash.contains(targetSum - value))
//                arrHash.add(value);
//            else
//                return new int[]{value, targetSum  - value};
//        }

        //Hint 2 Approach O(n)
        HashMap<Integer, Boolean> arrHash = new HashMap<>();
        for (int value : array) {
            if (!arrHash.containsKey(targetSum - value))
                arrHash.put(value, true);
            else
                return new int[]{value, targetSum  - value};
        }

        return new int[0];
    }
}
