package Module3.PriorityQueues;

import java.util.*;

public class inbuilt {
    public static void main(String[] args) {

        int arr[] = { 1, 3, 6, 5, 6, 7, 8, 98, 7, 67, 5, 3 };
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i : arr) {
            pq.add(i);
        }
    }
}
