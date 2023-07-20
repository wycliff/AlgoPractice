package src.main.java.mock;

public class PossibleBites {
    // 1,2 or 3 bites

    // top down : recursive 3^n
    private static int bite(int n){
        if (n<3) {
            return n;
        }else if(n==3){
            return 4;
        }
        return  bite(n - 1) + bite(n - 2) + bite (n - 3);
    }

    //Memoize
    private static int bite(int n, Integer[] memo){
        if (memo[n] != null) {
            return memo[n];
        }
        memo[n] = bite(n - 1, memo) + bite(n - 2, memo) + bite (n - 3, memo);
        return memo[n];
    }

    //bottom up: iterative
    private static int biteIterative(int n){
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else if (n == 2) {
            return 2;
        } else {
            int[] dp = new int[n + 1];
            dp[0] = 1;
            dp[1] = 1;
            dp[2] = 2;
            for (int i = 3; i <= n; i++) {
                dp[i] = dp[i - 1] + dp[i - 2] + dp[i - 3];
            }
            return dp[n];
        }
    }


    public static void main(String[] args) {
        Integer[] memo = {0, 1, 2, 4};
        System.out.println(biteIterative(8));
    }
}
