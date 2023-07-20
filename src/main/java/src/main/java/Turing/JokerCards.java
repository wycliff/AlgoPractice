package src.main.java.Turing;

import java.util.HashMap;

public class JokerCards {

    public static boolean removeNewChar(String s) {
        int l = s.length()/2;

        char[] sArr = s.toCharArray();
        char[] indA = new char[l];
        char[] indB = new char[l];

        System.arraycopy(sArr, 0, indA, 0, l);
        System.arraycopy(sArr, l, indB, 0, l);

        HashMap<Character, Integer> aHash = new HashMap<>();
        HashMap<Character, Integer> bHash = new HashMap<>();

        for(char elem : indA){
            if(!aHash.containsKey(elem)){
                aHash.put(elem, 1);
            }else{
                int count = aHash.get(elem);
                aHash.put(elem, count + 1);
            }
        }

        for(char elem : indB){
            if(!bHash.containsKey(elem)){
                bHash.put(elem, 1);
            }else{
                int count = bHash.get(elem);
                bHash.put(elem, count + 1);
            }
        }



        return false;
    }

    public static void main(String[] args) {

    }
}
