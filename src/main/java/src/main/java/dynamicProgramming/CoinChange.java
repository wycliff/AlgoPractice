package src.main.java.dynamicProgramming;

import java.util.Arrays;

//Bottom-up approach
public class CoinChange {

    public static int minCoins(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0] = 0;


        for (int a = 1; a <= amount; a++) {
            for (int c : coins) {
                if (a - c >= 0)
                    dp[a] = Math.min(dp[a], 1 + dp[a - c]); //recurrence relation
            }
        }

        return dp[amount] < amount + 1? dp[amount] : -1;

    }

    public static void main(String[] args) {
        int[] coins = {2}; // Example coin denominations (e.g., 1-cent, 2-cent, and 5-cent coins)
        int amount = 3; // Example target amount

        int minCoins = minCoins(coins, amount);
        System.out.println("Minimum number of coins needed: " + minCoins); // Output: 3 (one 5-cent coin and two 3-cent coins)
    }
}
