package Module2.Queues;

public class QueueUsingArrays {
    private int data[];
    private int front;
    private int rear;
    private int size;

    public QueueUsingArrays() {
        data = new int[5];
        front = -1;
        rear = -1;

    }

    public QueueUsingArrays(int capacity) {
        data = new int[capacity];
        front = -1;
        rear = -1;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int front() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        return data[front];
    }

    public void enqueue(int elem) {
        if (size == data.length) {
            // throw new QueueFullException();
            doubleCapacity();
        }
        if (size == 0) {
            front = 0;
        }

        rear++;
        if (rear == data.length) {
            rear = 0;
        }
        data[rear] = elem;
        size++;
    }

    private void doubleCapacity() {
        int temp[] = data;
        // System.out.println("double");
        data = new int[temp.length];
        int index = 0;
        for (int i = front; i < temp.length; i++) {
            data[index++] = temp[i];
        }
        for (int i = 0; i < front - 1; i++) {
            data[index++] = temp[i];
        }
        front = 0;
        rear = temp.length - 1;
    }

    public int dequeue() throws QueueEmptyException {
        if (size == 0) {
            throw new QueueEmptyException();
        }
        int temp = data[front];
        front++;
        if (front == data.length) {
            front = 0;
        }
        size--;
        if (size == 0) {
            front = -1;
            rear = -1;
        }
        return temp;
    }
}
