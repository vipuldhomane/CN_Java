package Module2.Queues;

import Module2.LinkedLists.Node;

public class QueueUsingLL<T> {
    Node<T> front;
    Node<T> rear;
    int size;

    public QueueUsingLL() {
        front = null;
        rear = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public T front() throws QueueEmptyException {
        if (front == null) {
            throw new QueueEmptyException();
        }
        return front.data;
    }

    public void enqueue(T elem) {
        Node<T> newNode = new Node<T>(elem);
        size++;
        if (rear == null) {
            front = newNode;
            rear = newNode;
        } else {
            rear.next = newNode;
            rear = newNode;
        }
    }

    public T dequeue() throws QueueEmptyException {
        if (front == null) {
            throw new QueueEmptyException();
        }
        T temp = front.data;
        front = front.next;
        size--;
        if (front == null) {
            rear = null;
        }
        return temp;
    }

}
