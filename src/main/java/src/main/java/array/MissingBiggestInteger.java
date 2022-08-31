package src.main.java.array;

import java.util.Arrays;

public class MissingBiggestInteger {
    public static int solution(int[] A) {
       //sort
        Arrays.sort(A);

        //find missing number
        for (int j = 0; j < A.length; j++) {
            if((j+1) < A.length) {
                if(A[j] == A[j + 1]){
                    continue;
                }
                if (A[j] + 1 != A[j + 1]) {
                    if (A[j] > 0) {
                        return A[j] + 1;
                    } else {
                        return 1; //return 1 if A[j] + 1 is a negative number
                    }
                }
            }else{
                if ( A[j] > 0) {
                    return  A[j] + 1;
                }else{
                    return 1;
                }
            }
        }
        return 0;
    }

    public static void main(String[] args) {
        int[] array = {1, 3, 6, 4, 1, 2}; // 5
       //  int[] array = {1, 3, 2}; // 4
       //   int[] array = {-1,-2}; // 1
        System.out.println(solution(array));
    }
}
