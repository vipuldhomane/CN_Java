package Module2.Stacks;

import java.util.Stack;

public class StackColllections {
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        // int arr[] = { 1, 23, 8, 4, 5, 7, 5, 4, 8, 7, 5, 4 };
        // // stack.push(20);
        // // System.out.println(stack.size());
        // for (int elem : arr) {
        // stack.push(elem);
        // }
        // while (!stack.isEmpty()) {
        // System.out.println(stack.pop());
        // }
        stack.push(5);
        stack.push(10);
        stack.push(15);
        System.out.print(stack.pop() + stack.size());

    }
}
