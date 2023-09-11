package src.main.java.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

public class BalanceBraces {
    public static boolean isValid(String s) {
        List<Character> indB = new ArrayList<>();
        for (int i = 0; i < s.length(); i++) {
            Character ch = s.charAt(i);
            indB.add(ch);
        }

        Stack<Character> myStack = new Stack<>();

        myStack.push(indB.get(0));

        for (int i = 1; i < s.length(); i++) {
            if (!myStack.isEmpty()) {
                if (myStack.peek().equals('(') && indB.get(i).equals(')')
                        || myStack.peek().equals('[') && indB.get(i).equals(']')
                        || myStack.peek().equals('{') && indB.get(i).equals('}')) {
                    myStack.pop();
                } else {
                    myStack.push(indB.get(i));
                }
            } else {
                myStack.push(indB.get(i));
            }
        }
        return myStack.isEmpty();
    }

    public static void main(String[] args) {
        String s = "[{()}]";
        System.out.println(isValid(s));
    }

}
