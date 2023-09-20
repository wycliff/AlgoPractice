package src.main.java.sorting;

public class BubbleSort {

    public static int[] bubble(int[] A) {
        int count = 0;
        int len = A.length;

        while (count < len - 1) {
            for (int i = len - 1; i > 0; i--) {
                if (A[i] < A[i - 1]) {
                    int temp = A[i - 1];
                    A[i - 1] = A[i];
                    A[i] = temp;
                }
            }
            count += 1;
        }

        return A;
    }

    public static void main(String[] args) {
        int[] A = {9, 8, 6, 5, 4, 3, 3, 2, 1, 0};
        int[] sorted = bubble(A);

        for (int i = 0; i < sorted.length; i++) {
            System.out.println(sorted[i]);
        }
    }
}
