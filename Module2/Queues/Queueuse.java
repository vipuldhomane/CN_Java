package Module2.Queues;

public class Queueuse {
    public static void main(String[] args) throws QueueFullException, QueueEmptyException {
        QueueUsingArrays queue = new QueueUsingArrays(2);
        queue.enqueue(10);
        queue.dequeue();
        queue.enqueue(30);
        queue.dequeue();
        queue.enqueue(20);
        queue.enqueue(50);
        queue.enqueue(90);
        queue.dequeue();
        // System.out.println(queue.size());
        System.out.println(queue.front());

    }
}
