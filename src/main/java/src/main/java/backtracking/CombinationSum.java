package src.main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

public class CombinationSum {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> output = new ArrayList<>();

        return output;
    }


    //Revision material
    public static void permutationWithRepetition() {
        // n = arr.length
        // r unique ordered numbers to be selected = number of loops
        //p =  n^r

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.println(arr[i] + " " + arr[j]);
                count += 1;
            }
            System.out.println("\n");
        }
        System.out.println("Count: " + count);
    }

    public static void permutationWithoutRepetition() {
        // n = arr.length
        // r unique ordered numbers to be selected = number of loops
        //p =  n! / (n-r)!
    }

    public static void combinationWithRepetition() {
        // n = arr.length
        // r unique ordered numbers to be selected = number of loops

    }

    public static void combinationWithoutRepetition() {
        // n = arr.length
        // r unique ordered numbers to be selected = number of loops
        //p =  n!/(n-r)!*r!

        int[] arr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        int count = 0;
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; j < n; j++) {
                System.out.println(arr[i] + " " + arr[j]);
                count += 1;
            }
            System.out.println("\n");
        }
        System.out.println("Count: " + count);
    }

    public static void main(String[] args) {
        permutationWithRepetition();
        combinationWithoutRepetition();
    }
}
