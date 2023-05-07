package Module2.Queues;

import java.util.Queue;

/**
 * ReverseQueue
 */
public class ReverseQueue {
    public static void reverseQueue(Queue<Integer> input) {
        // base case
        if (input.isEmpty()) {
            return;
        }
        // Storing and removing head form input
        int temp = input.remove();
        // Recursion on rest of the list
        reverseQueue(input);
        // adding temp in int the last of return list from recursion
        input.add(temp);
    }

}