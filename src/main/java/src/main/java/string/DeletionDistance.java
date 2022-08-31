package src.main.java.string;

public class DeletionDistance {
    static int deletionDistance(String str1, String str2) {
        // your code goes here
        char[] keyChars1 = str1.toCharArray();
        char[] keyChars2 = str2.toCharArray();
        int dist1 = 0;
        int dist2 = 0;
        int finalDist;

        for(char character : keyChars1){
            boolean isContainSameCharacter = str2.contains(String.valueOf(character));
            if(str2.contains(String.valueOf(character))){
                dist1+=1;
            }
        }

        for(char character : keyChars2){
            if(str1.contains(String.valueOf(character))){
                dist2+=1;
            }
        }

        finalDist = (str1.length() - dist1) + (str2.length() - dist2);
        return finalDist;
    }

    public static void main(String[] args) {
        System.out.println(deletionDistance("heat", "hit"));
    }
}
