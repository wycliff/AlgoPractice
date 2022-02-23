package src.main.java.stack;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MinMaxStackImpl {
    public static void main(String[] args) {
        MinMaxStack stack = new MinMaxStack();

    }

    static class MinMaxStack {
        List<Map<String, Integer>> minMaxStack = new ArrayList<>();
        List<Integer> myStack = new ArrayList();

        public int peek() {
            return myStack.get(myStack.size() - 1);
        }

        public int pop() {
            minMaxStack.remove(minMaxStack.size()-1);
            return myStack.remove(myStack.size() - 1);
        }

        public void push(Integer number) {
            HashMap<String, Integer> newMinMax = new HashMap();
            newMinMax.put("min", number);
            newMinMax.put("max", number);
            int stackSize = minMaxStack.size();
            if (stackSize > 0) {
                Map<String, Integer> lastMinMax = minMaxStack.get(stackSize-1);
                int min = Math.min(lastMinMax.get("min"), number);
                int max = Math.max(lastMinMax.get("max"), number);
                newMinMax.replace("min", min);
                newMinMax.replace("max", max);
            }
            minMaxStack.add(newMinMax);
            myStack.add(number);

        }

        public int getMin() {
            int stackSize = minMaxStack.size();
            Map<String, Integer> lastMinMax = minMaxStack.get(stackSize-1);
            return lastMinMax.get("min");
        }

        public int getMax() {
            int stackSize = minMaxStack.size();
            Map<String, Integer> lastMinMax = minMaxStack.get(stackSize-1);
            return lastMinMax.get("max");
        }
    }
}
