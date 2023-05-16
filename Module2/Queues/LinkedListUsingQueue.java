package Module2.Queues;

import java.util.LinkedList;
import java.util.Queue;

public class LinkedListUsingQueue {
    // Create an Empty queue

    public static LinkedList<Integer> createLinkedListWithQueue(int[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            queue.offer(arr[i]);
        }

        LinkedList<Integer> node = new LinkedList<Integer>();
        while (!queue.isEmpty()) {
            node.add(queue.poll());
        }

        return node;
    }

    public static void main(String[] args) {
        int arr[] = { 4, 5, 2, 1, 4, 5, 2, 6, 3 };
        LinkedList<Integer> list = createLinkedListWithQueue(arr);
        for (int i : list) {
            System.out.print(i + " ");
        }
    }
}
