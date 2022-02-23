package src.main.java.array;

public class SmallestDifference {
    public static void main(String[] args) {
    }

    // brute force approach
    public static int[] smallestDifference(int[] arrayOne, int[] arrayTwo) {
        //First  value of the absolute difference
        int absoluteDifference;
        int[] result = new int[]{};


        if (arrayOne[0] > arrayTwo[0]) {
            absoluteDifference = arrayOne[0] - arrayTwo[0];
        } else {
            absoluteDifference = arrayTwo[0] - arrayOne[0];
        }

        for (int i = 0; i < arrayOne.length; i++) {
            for (int j = 0; j < arrayTwo.length; j++) {
                int tempDifference = 0;
                int distTempFromZero;
                int distanceAbsFromZero;

                //getting the absolute difference per pair
                if (arrayOne[i] > arrayTwo[j]) {
                    tempDifference = arrayOne[i] - arrayTwo[j];
                } else {
                    tempDifference = arrayTwo[j] - arrayOne[i];
                }

                //keeping the number closest to zero
                if (0 > tempDifference) {
                    distTempFromZero = -tempDifference;
                } else {
                    distTempFromZero = tempDifference;
                }

                // distance from zero
                if (0 > absoluteDifference) {
                    distanceAbsFromZero = -absoluteDifference;
                } else {
                    distanceAbsFromZero = absoluteDifference;
                }

                //replace absolute
                if (distanceAbsFromZero > distTempFromZero) {
                    absoluteDifference = tempDifference;
                    result = new int[]{arrayOne[i], arrayTwo[j]};
                }
            }
        }
        return result;
    }

    public static int[] smallestDifference2(int[] arrayOne, int[] arrayTwo) {
        return new int[]{};
    }
}
