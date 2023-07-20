package src.main.java.backtracking;

import java.util.ArrayList;
import java.util.List;

//Backtracking
public class OperatorsDFS2 {
    /*
    Input: num = "123", target = 6
    Output: ["1*2*3","1+2+3"]

    */
    private static List<String> solve(String num, int target) {
        List<String> result = new ArrayList<>();
        dfs(result, num, "", 0, 0, 0, target);
        return result;
    }

    private static void dfs(List<String> accumulator, String num, String expr, int res, int prev, int pos, int target) {
        if (pos >= num.length()) {
            if (res == target) {
                accumulator.add(expr);
            }
            return;
        }

        for (int i = pos; i < num.length(); i++) {

            if (num.charAt(pos) == '0' && i == pos) {
                break;
            }

            String curr = num.substring(pos, i + 1);
            int currInt = Integer.parseInt(curr);

            if (pos == 0) {
                dfs(accumulator, num, expr + curr, res + currInt, currInt, i + 1, target);
            } else {
                dfs(accumulator, num, expr + "+" + curr, res + currInt, currInt, pos + 1, target);
                dfs(accumulator, num, expr + "-" + curr, res - currInt, -currInt, pos + 1, target);
                dfs(accumulator, num, expr + "*" + curr, res - prev + prev * currInt, prev * currInt, pos + 1, target);
            }
        }
    }

    public static void main(String[] args) {
        List<String> res = solve("123", 6);

        System.out.println(res);
    }
}
