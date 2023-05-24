package Module3.PriorityQueues.PQClass;

public class PriorityQueueTest {
    public static void main(String[] args) throws PriorityQueueException {
        Priority_queue<String> pq = new Priority_queue<>();
        pq.insert("vipul", 15);
        pq.insert("swathi", 10);
        pq.insert("radha", 25);
        pq.insert("neha", 55);
        pq.insert("Tanishka", 8);
        while (!pq.isEmpty()) {
            // System.out.println(pq.getMin());
            // pq.removeMin();
            System.out.println(pq.removeMin());
        }
    }

}
