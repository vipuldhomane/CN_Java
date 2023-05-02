package Module2.Stacks;

import java.util.Stack;

public class MinimumBracketReversal {
    /*
     * 
     * Time complexity: O(N)
     * Space complexity: O(N)
     * 
     * where N is the number of brackets
     * 
     */

    public static int countBracketReversals(String input) {
        int len = input.length();

        if (len == 0) {
            return 0;
        }
        if (len % 2 != 0) {
            return -1; // Only even number of brackets can be balanced
        }

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < len; i++) {
            char currentChar = input.charAt(i);

            if (currentChar == '{') {
                stack.push(currentChar);
            } else {
                // Pop if there is a balanced pair
                if (!stack.isEmpty() && stack.peek() == '{') {
                    stack.pop();
                } else {
                    stack.push(currentChar);
                }
            }
        }

        int count = 0;

        // Only unbalanced brackets are there in stack now
        while (!stack.isEmpty()) {
            char char1 = stack.pop();
            char char2 = stack.pop();

            /*
             * When char1 = } and char2 = {, then we need to reverse both of them
             * so count will increase by 2
             */
            if (char1 != char2) {
                count += 2;
            } else {
                count += 1;
            }
        }

        return count;
    }

    public static int countBracketReversals1(String input) {
        // Your code goes here
        if (input.length() % 2 != 0) {
            return -1;
        }
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < input.length(); i++) {
            char c = input.charAt(i);
            if (c == '{') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if (stack.peek() == '}') {
                    stack.push(c);
                } else if (stack.peek() == '{') {
                    stack.pop();
                }
            }
        }

        while (!stack.isEmpty()) {
            char c1 = stack.pop();
            char c2 = stack.pop();

            if (c1 == c2) {
                count = count + 1;
            } else {
                count = count + 2;
            }
        }
        return count;

    }

}
