package src.main.java.array;
import java.util.*;

public class MissingSmallestInteger {


// you can also use imports, for example:


// you can write to stdout for debugging purposes, e.g.
// System.out.println("this is a debug message");


    public int solution(int[] A) {
        // sort
        // is last element < 0 return 1
        // keep increasing from start by 1 if present proceed if not return the value

        // HashMap
        Arrays.sort(A);

        int lastElemIndex = A.length-1;
        if(A[lastElemIndex] <= 0){
            return 1;
        }

        HashSet<Integer> set = new HashSet<>();

        for(int i=0; i<A.length; i++){
            if(!set.contains(A[i])){
                set.add(A[i]);
            }
        }

        for(Integer num : set){
            if(!set.contains(num+1)){
                return num+1;
            }
        }
        return 1;
    }
}