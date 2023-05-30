package src.main.java.dynamicProgramming;

import com.sun.tools.javac.util.ArrayUtils;

import java.util.Arrays;
import java.util.Collections;

public class MinCoinsChange {
    //sub-optimal solution
    public static int minNumberOfCoinsForChange1(int n, int[] denoms) {
        Integer[] arr = new Integer[denoms.length];
        for (int i = 0; i < denoms.length; i++) {
            arr[i] = denoms[i];
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int count = 0;
        int i = 0;

        while (n > 0) {
            if (n < arr[i]) {
                i++;
                continue;
            }

            int quotient = n / arr[i];
            n = n % arr[i];
            count += quotient;

            //if the remainder is less than the current denomination, move to the next
            if (n < arr[i]) {
                i++;
            }
        }

        if (count > 0) {
            return count;
        } else {
            return -1;
        }
    }

    //optimal space: O(n)  time:0(nd)   n-size of n d-no of denoms
    public static int minNumberOfCoinsForChange2(int n, int[] denoms) {
        //General formula : numOfCoins[amount] = min(numOfCoins[amount],1 + numOfCoins[amount  - coin_denom])

        Integer[] numOfCoins = new Integer[n+1];
        for(int x=0 ; x<=n ; x++){
            numOfCoins[x] = Integer.MAX_VALUE;
        }

        numOfCoins[0] = 0;

       // For each  coin_denom:
        for(int i=0;i<denoms.length; i++){
            for(int j=0; j<=n; j++){
                if(j >= denoms[i]){
                    numOfCoins[j] = Math.min(numOfCoins[j], 1+ numOfCoins[j - denoms[i]]);
                }
            }
        }

        if(numOfCoins[n] == Integer.MAX_VALUE){
            return -1;
        }else{
            return numOfCoins[n];
        }
    }


    public static void main(String[] args) {
        //int[] array = {1,2,4};
        int[] array = {39, 45, 130, 40, 4, 1, 60, 75};
        System.out.println(minNumberOfCoinsForChange2(135, array));
    }
}