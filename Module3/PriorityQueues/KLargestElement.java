package Module3.PriorityQueues;

import java.util.*;

public class KLargestElement {
    public static ArrayList<Integer> kLargest(int input[], int k) {
        ArrayList<Integer> ans = new ArrayList<>();
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        // add first k element in the pq
        for (int i = 0; i < k; i++) {
            pq.add(input[i]);
        }
        for (int i = k; i < input.length; i++) {
            if (pq.peek() < input[i]) {
                pq.poll();
                pq.add(input[i]);
            }
        }
        while (!pq.isEmpty()) {
            // System.out.println(pq.poll());
            ans.add(pq.poll());
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 3, 5, 6, 8, 7, 11, 23, 22, 9 };
        ArrayList<Integer> ans = kLargest(arr, 3);
        System.out.println(ans);
    }
}
