package Module2.Queues;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseFirstKElements {

    public static Queue<Integer> reverseKElements(Queue<Integer> input, int k) {
        Stack<Integer> s = new Stack<>();
        // push first k elements into the stack
        for (int i = 0; i < k; i++) {
            s.push(input.poll());
        }

        // stack to queue
        while (!s.empty()) {
            input.add(s.pop());

        }
        // remove remaining elements and add back to input
        for (int i = 0; i < input.size() - k; i++) {
            input.add(input.poll());
        }
        return input;

    }

    // using recursion
    public static Queue<Integer> reverseKElementsRec(Queue<Integer> input, int k) {
        if (k == 0 || k == input.size()) {
            return input;
        }
        int temp = input.poll();
        // recursion call on k-1
        reverseKElementsRec(input, k - 1);
        // adding temp back
        input.add(temp);
        return input;

    }

    public static void main(String[] args) {
        Queue<Integer> q = new LinkedList<>();
        q.add(10);
        q.add(20);
        q.add(30);
        q.add(40);
        q.add(50);

    }

}
