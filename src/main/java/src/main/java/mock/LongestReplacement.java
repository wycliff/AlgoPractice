package src.main.java.mock;

import java.util.HashMap;
import java.util.Map;

public class LongestReplacement {
    public static int solutionLongReplace(int[] A) {
        if (A.length <= 4) {
            return A.length;
        }

        int maxLength = 0; //longest replaced
        int i = 0;
        int j = 4;
        //3, 3, 2, 1, 2, 2, 9, 3, 3
        while(j<A.length){
            if(isValid(A, i, j)){
                maxLength = Math.max(maxLength, j-i+1);
                j+=1;
            }else{
                i+=1;
            }
        }

        return maxLength;
    }


    public static boolean isValid(int[] A, int s, int e) {
        int[] trim = new int[e-s+1];

        //get sub-array
        for( int k=0; k<=(e-s); k++){
            trim[k] = A[s+k];
        }

        HashMap<Integer, Integer> validHash = new HashMap<>();
        int maxCount = 0;

        //make hash
        for (int i = 0; i < trim.length; i++) {
            if (!validHash.containsKey(trim[i])) {
                validHash.put(trim[i], 1);
            } else {
                int count = validHash.get(trim[i]) + 1;
                validHash.put(trim[i], count);
            }
        }

        //biggest element in the hashmap
        for (Map.Entry<Integer, Integer> entry : validHash.entrySet()) {
            if(entry.getValue() > maxCount){
                maxCount = entry.getValue();
            }
        }

        if(trim.length - maxCount <= 3){
            return true;
        }

        return false;
    }

    public static void main(String[] args) {
        //input
        //int[] A = {1, 1, -10, 3, -10, 3, -10};
        //int[] A = {-9, 8};
        //int[] A = {2, 3, 3, 3, 3, 1};
        int[] A = {3, 3, 2, 1, 2, 2, 9, 3, 3};
        System.out.println(solutionLongReplace(A));

        //time : 0(n)
        //space : 0(n)
    }
}
