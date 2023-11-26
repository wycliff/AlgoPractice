package src.main.java.dynamicProgramming;

import java.util.Arrays;

//Bottom-up approach
public class CoinChange {

    public static int minCoins(int[] coins, int amount) {
        // bottom-up
        // dp[0]...dp[amount]
        // dp[] arr
        // prefill - arbitrary value
        // pass through 0 - amount
        // estblish :
           // consider each coin + 1 -> amount - coin = dp[val]
           // dp[val] + 1

        // return

        //11 - 12
        //1,2,4

        int[] dp = new int[amount + 1];
        Arrays.fill(dp, amount + 1);
        dp[0]=0;

        for(int i=1; i<=amount; i++){
            for(int c : coins){
                if(i-c>=0) {
                    dp[i] = Math.min(dp[i], 1 + dp[i - c]);
                }
            }
        }

        return dp[amount]<amount + 1? dp[amount] : -1;
    }

    public static void main(String[] args) {
        int[] coins = {1,2,5}; // Example coin denominations (e.g., 1-cent, 2-cent, and 5-cent coins)
        int amount = 11; // Example target amount

        int minCoins = minCoins(coins, amount);
        System.out.println("Minimum number of coins needed: " + minCoins);

        //Time  O(amount * c) c=coin denoms
        //Space O(amount)
    }
}
