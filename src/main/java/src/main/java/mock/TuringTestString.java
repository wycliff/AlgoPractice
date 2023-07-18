package src.main.java.mock;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

//Turing : Baseball game
public class TuringTestString {

    // x - add
    // "+" - New score that is the sum of the previous 2
    // "D" - New score double the previous
    // "C" - Delete most recent record

    public static int calPoints(String[] ops) {
        int result =0;
        int l = ops.length;

        List<Integer> intList = new ArrayList<>(ops.length);

        for (int i = 0; i < l; i++) {
            int listSize = intList.size();

            switch (ops[i]) {
                case "+":
                    intList.add(intList.get(listSize - 1) + intList.get(listSize - 2));
                    break;
                case "D":
                    intList.add(intList.get(listSize - 1) * 2);
                    break;
                case "C":
                    intList.remove(intList.get(listSize - 1));
                    break;
                default:
                    int num = Integer.parseInt(ops[i]);
                    intList.add(num);
            }

        }

        for (Integer integer : intList) {
            result += integer;
        }

        return result;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        // String[] ops = sc.nextLine().split(" ");

        String[] ops = {"5", "2", "C", "D", "+"};
        System.out.println(calPoints(ops));
    }

}
