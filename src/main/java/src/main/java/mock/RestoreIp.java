package src.main.java.mock;
//5 : String manipulation / Backtracking
//        Restore IP
//        Given a string of integers, return all possible valid IPV4 that can be constructed from it
//
//        String[] expected = {"1.2.1.212", "1.2.12.12", "1.2.121.2", "1.21.2.12", "1.21.21.2", "1.212.1.2", "12.1.2.12", "12.1.21.2", "12.12.1.2", "121.2.1.2"};
//        assertArrayEquals(expected, RestoreIP.solve("121212"));


// Soln
// ascertain all possibilities : triple for loop
// return only valid Ip nums

import java.util.ArrayList;
import java.util.List;

public class RestoreIp {
    public static List<String> ipResolve(String s) {
        List<String> output = new ArrayList<>();

        int l = s.length();

        for (int i = 0; i < l; i++) {
            for (int j = i + 1; j < l; j++) {
                for (int k = j + 1; k < l; k++) {
                    String ip = generateIP(s, i, j, k);
                    if (!ip.equals(""))
                        output.add(ip);
                }
            }
        }
        return output;
    }

    public static String generateIP(String s, int i, int j, int k) {
        String s1 = s.substring(0, i + 1);
        String s2 = s.substring(j, k);
        String s3 = s.substring(k, k + 1);
        String s4 = s.substring(k + 1);

        if (check(s1) && check(s2) && check(s3) && check(s4)) {
            return s1 + "." + s2 + "." + s3 + "." + s4;
        } else {
            return "";
        }
    }

    public static boolean check(String s) {
        // 0-255
        // no leading zeros
        //not more than 3 characters

        if (s.length() == 0 || s.length() > 3)
            return false;

        int num = Integer.parseInt(s);
        if (num < 0 || num > 255)
            return false;

        //leading zero
        if (s.charAt(0) == 0 && s.length() > 1)
            return false;


        return true;
    }


    //Backtracking solution


    public static void main(String[] args) {
        String s = "hello";
        System.out.println(ipResolve("121212")); //n^3
    }
}
