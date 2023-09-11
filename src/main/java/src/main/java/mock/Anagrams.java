package src.main.java.mock;

import java.util.*;

public class Anagrams {

//    Input: strs = ["eat","tea","tan","ate","nat","bat"]
//    Output: [["bat"],["nat","tan"],["ate","eat","tea"]]

    public static List<List<String>> group(String[] strs){
        //Map
        HashMap<String, List<String>> m = new HashMap<>();
        List<List<String>> output = new ArrayList<>();

        //loop
        for(int i=0; i<strs.length; i++){
            String s = strs[i];
            char[] ch = s.toCharArray();
            Arrays.sort(ch);

            String s2 = String.valueOf(ch);

            if(!m.containsKey(s2)){
                List<String> valStrs = new ArrayList<>();
                m.put(s2,valStrs);
            }
            m.get(s2).add(s);
        }

        //loop through the map
        for(Map.Entry<String,List<String>> entry : m.entrySet()){
            output.add(entry.getValue());
        }

        return output;
    }


    public static void main(String[] args) {

    }
}
