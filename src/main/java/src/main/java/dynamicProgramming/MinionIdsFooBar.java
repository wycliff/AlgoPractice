package src.main.java.dynamicProgramming;

//Generate prime numbers starting from a specific value
public class MinionIdsFooBar {

    public static String solution(int i) {
        String primeString = getPrimeString(i + 5);

        StringBuilder minionId = new StringBuilder();

        for(int j=i; j<i+5; j++){
            minionId.append(primeString.charAt(j));
        }

        return minionId.toString();

    }

    public static void main(String[] args) {
        System.out.println(solution(0));
    }

    public static String getPrimeString(int p) {
        int status = 1;
        int num = 3;

        //Make the string of primes
        StringBuilder ids = new StringBuilder();

        if (p >= 1) {
            System.out.println("First " + p + " prime numbers are:");
            //2 is a known prime number
            System.out.println(2);
            ids.append(2);
        }

        for (int i = 2; i <= p; ) {
            for (int j = 2; j <= Math.sqrt(num); j++) {
                if (num % j == 0) {
                    status = 0;
                    break;
                }
            }

            if (status != 0) {
                ids.append(num);
                System.out.println(num);
                i++;
            }
            status = 1;
            num++;
        }

        System.out.println(ids.toString());
        return ids.toString();
    }

    private static String getMinionId(int n) {
        String primeString = getPrimeString(n + 5);

        StringBuilder minionId = new StringBuilder();

        for(int i=n; i<n+5; i++){
            minionId.append(primeString.charAt(i));
        }

        return minionId.toString();
    }

}
