package Module3.PriorityQueues.PQClass.PQmax;

public class PriorityQueueTest {
    public static void main(String[] args) throws PriorityQueueException {
        Priority_queueMax<String> pq = new Priority_queueMax<>();
        pq.insert("vipul", 15);
        pq.insert("swathi", 10);
        pq.insert("radha", 25);
        pq.insert("neha", 5);
        pq.insert("Tanishka", 8);
        while (!pq.isEmpty()) {
            // System.out.println(pq.getMin());
            // pq.removeMin();
            System.out.println(pq.removeMax());
        }
    }

}
