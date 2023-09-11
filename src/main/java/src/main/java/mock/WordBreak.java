package src.main.java.mock;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class WordBreak {

    static boolean found = false;

    public static boolean wordBreak(List<String> dict, String word) {
        //For quick lookup
        HashSet<String> wordSet = new HashSet<>(dict);
        recursiveSoln(word, 0, wordSet);
        return false;
    }

    public static boolean wordBreakDP (String s, List<String> wordDict ) {

        Set<String> wordSet = new HashSet<>(wordDict);

        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true;

        for (int i = 1; i <= s.length(); i++) {
            for (int j = 0; j < i; j++) {
                if (dp[j] && wordSet.contains(s.substring(j, i))) {
                    dp[i] = true;
                }
            }
        }

        return dp[s.length()];
    }


    public static void recursiveSoln(String word, int index, HashSet<String> wordSet) {
        if (index >= word.length()) {
            found = true;
            System.out.println(found);
        }

        if(found)
            return;

        for(int i= index; i<word.length(); i++){
            if(wordSet.contains(word.substring(index, i))){ // substring: begin index inclusive/ end index exclusive
                recursiveSoln(word, i, wordSet);
            }
        }

    }

    public static void main(String[] args) {
        String[] dictArr = {"ag", "al", "icl", "mag", "magic", "ly", "lly"};
        List<String> dict = new ArrayList<>();
        for(int j=0 ; j<dictArr.length; j++){
            dict.add(dictArr[j]);
        }
        String word = "magiclly";

        wordBreak(dict, word);

    }
}
