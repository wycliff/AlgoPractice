package src.main.java.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

//O(n^2) time / O(n) space
public class ThreeNumberSum {
    public static void main(String[] args) {
    }

    public static List<Integer[]> threeNumberSum(int[] array, int targetSum) {

        Arrays.sort(array); // Arrays.sort(int[]) Under the hood, it uses a Dual-Pivot Quicksort algorithm. - JDK 10
        ArrayList<Integer[]> triplets = new ArrayList();

        //loop through entire
        for (int i = 0; i < array.length - 2; i++) {
            int left = i + 1;
            int right = array.length - 1;

            //Left and right pointers don' t overlap or pass each other
            while (left < right) {

                //if the current - i + L + R = target
                if (targetSum == (array[i] + array[left] + array[right])) {
                    //add triplet
                    triplets.add(new Integer[]{array[i], array[left], array[right]});
                    left += 1;
                    right -= 1;
                } else if ((array[i] + array[left] + array[right]) < targetSum) {
                    left += 1;
                } else if ((array[i] + array[left] + array[right]) > targetSum) {
                    right -= 1;
                }
            }
        }
        return triplets;
    }
}
