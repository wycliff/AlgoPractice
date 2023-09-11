package src.main.java.string;

public class IsPalindrome {

    public static  boolean isPalindrome(String s) {
        int i = 0;
        s = processString(s);
        int j = s.length()-1;
        char[] charArr = s.toCharArray();

        if(s.isEmpty()){
            return true;
        }

        while(j<j){
            if(charArr[i]==charArr[j]){
                i++;
                j--;
            }else{return false;}
        }

        return true;
    }


    private static String processString(String s){
        //convert to lower case
        s = s.toUpperCase();

        //remove non-alphanumeric
        // Alphanumeric characters lie in the ASCII value range of [65, 90] for uppercase alphabets
        // [97, 122] for lowercase alphabets
        // and [48, 57] for digits
        s = s.replaceAll("[^a-zA-Z0-9]", "");
        s = s.replaceAll("\\s", "");
        return s;
    }
    public static void main(String[] args) {
        String s = "A man, a plan, a canal: Panama";
        //String s = "aa";
        System.out.println(isPalindrome(s));
    }
}

