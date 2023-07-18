package src.main.java.mock;

import java.util.*;
//1
public class ValidTriplets {
//    Sort
//    Pass through the array (length-2) considering pairs , excluding the index under consideration
//    two ptrs
//    Check : a < b + c
//    Counter ++

    public static int validTrips(int[] A) {
        int counter = 0;
        Arrays.sort(A);
        for (int i = 0; i < A.length - 2; i++) {
            for (int j = i + 1; j < A.length - 1; j++) {
                for (int k = j+1; k<A.length ; k++){
                    if(A[i] < (A[j] + A[k]) && A[j] < (A[i] + A[k]) && A[k] < (A[j] + A[i])){
                        System.out.println(A[i] );
                        System.out.println(A[j]);
                        System.out.println(A[k]);
                        System.out.println("\n");
                        counter++;
                    }
                }
            }
        }
        return counter;
    }

    public static void main(String[] args) {
        int[] A = {2,2,3,4,6,8}; // time: O(n^3)   space : O(1)
        System.out.println(validTrips(A));
    }

    //complexity: change with relation to the size of the input

}
