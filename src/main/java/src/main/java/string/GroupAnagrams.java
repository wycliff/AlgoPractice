package src.main.java.string;

import java.util.*;

/*
Given an array of strings, group anagrams together.

Example:
Input: ["eat", "tea", "tan", "ate", "nat", "bat"],
Output:
[
  ["ate","eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:

All inputs will be in lowercase.
The order of your output does not matter.*/

public class GroupAnagrams {

    public static void main(String[] args) {
        String strs[] = {"eat", "tea", "tan", "ate", "nat", "bat"};
        System.out.println(groupAnagrams(strs));
    }

    public static List<List<String>> groupAnagrams(String[] strs) {
        List output = new ArrayList<List<String>>();
        HashMap listMap = new HashMap<String, List<String>>();

        for(String str : strs){
            char[] keyChars = str.toCharArray();
            int r = keyChars.length;
            Arrays.sort(keyChars);
            String key = String.valueOf(keyChars);


            if(!listMap.containsKey(key)){
                List anagrams = new ArrayList<String>();
                listMap.put(key, anagrams);
            }

            if(listMap.containsKey(key)){
                List anagrams = (List) listMap.get(key);
                anagrams.add(str);
            }
        }

        for (Object value : listMap.values()){
            output.add(value);
        }

        return output;
    }

}
