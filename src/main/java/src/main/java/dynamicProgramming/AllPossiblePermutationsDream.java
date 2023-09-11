package src.main.java.dynamicProgramming;

import java.util.ArrayList;
import java.util.List;

public class AllPossiblePermutationsDream {
    public static List<List<Integer>> allPrimes(int[] input) {
        List<List<Integer>> accumulatedRes = new ArrayList<>();
        List<Integer> curr = new ArrayList<>();

        List<Integer> inputList = new ArrayList<>();
        for (int i : input) {
            inputList.add(i);
        }

        dfs(curr, inputList, accumulatedRes);
        return accumulatedRes;
    }

    public static void dfs(List<Integer> curr, List<Integer> remainingInput, List<List<Integer>> accumulatedRes) {
        //exit condition
        if (remainingInput.size() == 0) {
            accumulatedRes.add(curr);
            return;
        }

        //loop
        for (int i = 0; i < remainingInput.size(); i++) {
            int nextInt = remainingInput.get(i);
            curr.add(nextInt);
            List<Integer> newRemainingInput = remainingInput;
            removeElement(i, newRemainingInput);
            dfs(curr, newRemainingInput, accumulatedRes);
        }
    }

    public static List<Integer> removeElement(int i, List<Integer> in) {
        in.remove(i);
        return in;
    }

    public static void main(String[] args) {
        int[] primes = {1, 2, 3}; // [123] [132] [213] [231]
        System.out.println(allPrimes(primes));
    }
}
