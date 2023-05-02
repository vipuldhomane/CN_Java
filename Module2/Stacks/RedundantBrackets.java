package Module2.Stacks;

import java.util.Stack;

public class RedundantBrackets {
    // CN Solution
    /*
     * Time complexity: O(N)
     * Space complexity: O(N)
     * 
     * where N is the length of the input expression
     */

    private static boolean find(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }

        return false;
    }

    public static boolean checkRedundantBrackets(String expression) {
        Stack<Character> stk = new Stack<>();

        for (int i = 0; i < expression.length(); ++i) {
            if (expression.charAt(i) == '(' || find(expression.charAt(i))) {
                stk.push(expression.charAt(i));
            } else if (expression.charAt(i) == ')') {
                boolean hasOperator = false;

                while (!stk.isEmpty() && stk.peek() != '(') {
                    stk.pop();
                    hasOperator = true;
                }

                if (!hasOperator) {
                    return true;
                }

                if (!stk.isEmpty()) {
                    stk.pop();
                }
            }
        }

        return false;
    }

    // Another Solution
    public static boolean checkRedundantBrackets1(String expression) {
        // Your code goes here
        Stack<Character> stack = new Stack<Character>();
        int count = 0;
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            System.out.print(c);

            if (c == ')') {
                // System.out.println();
                while (!stack.isEmpty() && stack.peek() != '(') {
                    count = count + 1;
                    stack.pop();
                    // System.out.print(stack.pop());
                }
                // System.out.println();
                // System.out.println(count);
                if (count == 0 || count == 1) {
                    return true;
                }
                stack.pop();
                count = 0;

            } else {
                stack.push(c);
            }
        }
        return false;
    }

    public static boolean checkRedundantBrackets2(String expression) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < expression.length(); i++) {
            char ch = expression.charAt(i);
            if (ch != ')') {
                stack.push(ch);
            } else {
                if (stack.pop() == '(') {
                    return true;
                }
                while (!stack.isEmpty() && stack.peek() != '(') {
                    stack.pop();
                }
                stack.pop();
            }
        }
        return false;
    }

    public static void main(String[] args) {
        String str = "(c)";
        System.out.println(checkRedundantBrackets2(str));
    }
}
