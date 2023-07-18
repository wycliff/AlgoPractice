package src.main.java.array;
//Google Mock Interview
//We are given an array A consisting of N integers. In one move, we can choose any element in this array and replace it with any value.
//We are interested in the longest consistent segment of identical elements. For example, given an array A = [3, -3, 3, 3, 3, 1, -3], the segment that we are looking for is [3, 3, 3].
//
//What is the maximum length of such a segment that we can achieve by performing at most three moves on the array?
//
//Write a function:
//class Solution { public int solution(int[] A); }
//
//that, given an array A of N integers, returns the maximum length of a consistent segment of identical elements in the array A that can be obtained after replacing up to three elements in the array.
//
//        Examples:
//        Given A = [-9, 8], your function should return 2. One of the correct ways to obtain such a solution is to use one move and change 8 into -9.
//        Given A = [1, 1, -10, 3, -10, 3, -10], your function should return 6. By performing three moves we can obtain the following array: [1, -10, -10, -10, -10, -10, -10].
//        Given A = [2, 3, 3, 3, 3, 1], your function should return 6. We can perform two moves to replace the first and last elements with 3s.
//        Given A = [3, 3, 2, 1, 2, 2, 9, 3, 3], your function should return 6. By performing three moves we can obtain the following array: [3, 3, 2, 2, 2, 2, 2, 2, 3].
//
//        Assume that:
//        N is an integer within the range [1..100];
//        each element of array A is an integer within the range [−10..10].

import java.util.HashMap;
import java.util.Map;

public class MaxLengthSlideWindow {
    public static void main(String[] args) {
        //input
        int[] A = {1, 1, -10, 3, -10, 3, -10};
        //int[] A = {-9, 8};
        //int[] A = {2, 3, 3, 3, 3, 1};
        //int[] A = {3, 3, 2, 1, 2, 2, 9, 3, 3};
        System.out.println(solution1(A));
    }

    //Check different lengths for valid replacements and return the Max length
    public static int solution1(int[] A) {
        //base case : up to 4 items, it will always be the length of the array
        if (A.length <= 4) {
            return A.length;
        }

        int maxLength = 0;
        int k = 4; //window size
        int start = 0;
        int l = A.length;
        int i = start;

        while (i + k < l) {
            do {
                k += 1;
            }
            while (isValid(subArray(i, k, A)) && k<l);

            if (!isValid(subArray(i, k, A))) {
                k -= 1;
            }

            maxLength = Math.max(k, maxLength);
            i++;
        }

        return maxLength;
    }

    //generate subarray
    public static int[] subArray(int start, int windowSize, int[] A) {
        int[] subArray = new int[windowSize];
        for (int i = 0; i < windowSize; i++) {
            //check bounds
            if (A.length < (i + start) + 1)
                break;
            subArray[i] = A[i + start];
        }
        return subArray;
    }


    //true, if we can replace at most 3 elements and get all identical elements
    public static boolean isValid(int[] A) {
        HashMap<Integer, Integer> hash = new HashMap();

        //creating the hashmap
        for (int i = 0; i < A.length; i++) {
            if (!hash.containsKey(A[i])) {
                hash.put(A[i], 1);
            } else {
                int newVal = hash.get(A[i]) + 1;
                hash.put(A[i], newVal);
            }
        }

        //loop through hash map to ascertain if we can get a valid soln
        //how: arrayLength - value <= 3
        //method 1
        for (Map.Entry<Integer, Integer> item : hash.entrySet()) {
            int arrayLength = A.length;
            if (arrayLength - item.getValue() <= 3) {
                return true;
            }
        }

        //method 2
//        AtomicBoolean isValid = new AtomicBoolean(false);
//        hash.forEach(
//                (key,value) ->{
//                    int arrayLength = A.length;
//                    if(arrayLength - value<=3){
//                        isValid.set(true);
//                    }
//                }
//        );

        return false;
    }


    //Chat GPT
    public static int solution2(int[] A) {
        int maxSegmentLength = 0;
        int n = A.length;

        for (int i = 0; i < n; i++) {
            int count = 1;
            Map<Integer, Integer> freq = new HashMap<>();
            freq.put(A[i], 1);

            for (int j = i + 1; j < n && j <= i + 3; j++) {
                freq.put(A[j], freq.getOrDefault(A[j], 0) + 1);
                count = Math.max(count, freq.get(A[j]));
            }

            maxSegmentLength = Math.max(maxSegmentLength, count + Math.min(3, n - i - count));
        }

        return maxSegmentLength;
    }
}
