package src.main.java.searching;

public class BinarySearch {
    public static int binarySearch(int[] array, int target) {
        int right = array.length - 1;
        return binarySearchImpl(target, 0, right, array);
    }

    public static int binarySearchImpl(int target, int left, int right, int[] array) {
        if (left > right) {
            return -1;
        }

        int middle = (left + right) / 2;
        int value = array[middle];

        if (target == value) {
            return middle;
        } else if (target > value) {
            return binarySearchImpl(target, middle + 1, right, array);
        } else {
            return binarySearchImpl(target, left, middle -1, array);
        }
    }

    public static void main(String[] args) {
        int[] testData = {0,1,21,33,45,45,61,71,72,73};
        System.out.println(binarySearch(testData, 33));
    }
}
