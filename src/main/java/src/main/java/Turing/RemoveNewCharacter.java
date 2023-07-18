package src.main.java.Turing;

import java.util.Arrays;

public class RemoveNewCharacter {
    public static char removeNewChar(String s, String t) {
        char[] indS = s.toCharArray();
        char[] indT = t.toCharArray();

        Arrays.sort(indS);
        Arrays.sort(indT);

        int ls = s.length();
        int lt = t.length();

        if(ls==0){
            return indT[0];
        }

        int i = 0;
        while (i < ls) {
            if (indS[i] != indT[i]) {
                return indT[i];
            }
            i++;
        }

        return indT[lt-1];
    }

    public static void main(String[] args) {
        String s = "abcd";
        String t= "ceadb";
        System.out.println(removeNewChar(s,t));
    }
}
