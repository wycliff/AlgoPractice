package src.main.java.dynamicProgramming;


import java.util.ArrayList;
import java.util.List;

public class NumberPermutations {

    public static List<Integer> findPermutations(int number) {
        List<Integer> result = new ArrayList<>();
        String numStr = Integer.toString(number);
        char[] digits = numStr.toCharArray();

        backtrack("", digits, result);

        return result;
    }

    private static void backtrack(String currPermutation, char[] remainingDigits, List<Integer> result) {
        if (remainingDigits.length == 0) {
            result.add(Integer.parseInt(currPermutation));
            return;
        }

        for (int i = 0; i < remainingDigits.length; i++) {
            char nextDigit = remainingDigits[i];
            String newPermutation = currPermutation + nextDigit;
            char[] newRemainingDigits = removeElement(remainingDigits, i);
            backtrack(newPermutation, newRemainingDigits, result);
        }
    }

    private static char[] removeElement(char[] array, int index) {
        char[] result = new char[array.length - 1];
        int j = 0;
        for (int i = 0; i < array.length; i++) {
            if (i != index) {
                result[j++] = array[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int number = 123;
        List<Integer> permutations = findPermutations(number);
        System.out.println(permutations);
    }
}