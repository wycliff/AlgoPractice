package src.main.java.dynamicProgramming;

public class Straicase {

    public static int ascend(int hop, int n) {
        int count = 0;
        n = n - hop;
        if (n == 0) {
            return 1;
        } else if (n < 1) {
            return 0;
        } else {
            count += ascend(1, n) + ascend(2, n) + ascend(3, n);
        }

        return count;
    }

    public static void main(String args[]) {
        System.out.println(ascend(0, 4));
    }
}
