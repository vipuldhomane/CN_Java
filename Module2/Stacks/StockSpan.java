package Module2.Stacks;

import java.util.Stack;

public class StockSpan {
    /*
     * 
     * Time complexity: O(N)
     * Space complexity: O(N)
     * 
     * where N is the number of days
     * 
     */

    public static int[] stockSpan(int[] price) {
        Stack<Integer> stk = new Stack<>();
        int n = price.length;

        int[] output = new int[n];

        stk.push(0);
        output[0] = 1;

        for (int i = 1; i < n; ++i) {
            while (!stk.isEmpty() && price[stk.peek()] < price[i]) {
                stk.pop();
            }

            if (stk.isEmpty()) {
                output[i] = i + 1;
            } else {
                output[i] = i - stk.peek();
            }

            stk.push(i);
        }

        return output;
    }

    public static int[] stockSpan1(int[] price) {
        // Your code goes here
        int[] span = new int[price.length];
        Stack<Integer> stack = new Stack<Integer>();
        span[0] = 1;
        stack.push(0);

        for (int i = 1; i < price.length; i++) {
            while (!stack.isEmpty() && price[stack.peek()] < price[i]) {
                stack.pop();
            }
            // System.out.println(stack.size());

            if (stack.isEmpty()) {
                span[i] = i + 1;
            } else {
                // System.out.println("i = "+i);
                // System.out.println("top = "+stack.peek());
                span[i] = i - stack.peek();
            }
            stack.push(i);
            // System.out.println("New top: "+stack.peek());
            // System.out.println();
        }
        return span;
    }

}
