package Module2.Stacks;

import java.util.Stack;

public class ReverseStack {
    public static void reverseStack(Stack<Integer> input, Stack<Integer> extra) {

        if (input.size() == 0 || input.size() == 1) {
            return;
        }
        int top = input.pop();
        reverseStack(input, extra);
        while (!input.isEmpty()) {
            extra.push(input.pop());

        }
        input.push(top);

        while (!extra.isEmpty()) {
            input.push(extra.pop());
        }
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(10);
        stack.push(20);
        stack.push(30);
        stack.push(40);
        stack.push(50);
        stack.push(60);
        stack.push(70);
    }
}
