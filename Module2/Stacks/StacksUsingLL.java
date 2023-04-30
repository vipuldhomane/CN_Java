package Module2.Stacks;

import Module2.LinkedLists.Node;

public class StacksUsingLL<T> {
    private Node<T> head;
    private int size;

    public StacksUsingLL() {
        head = null;
        size = 0;
    }

    public int size() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void push(T elem) {
        Node<T> newNode = new Node<T>(elem);
        newNode.next = head;
        head = newNode;
        size++;
    }

    public T top() throws StackEmptyException {
        if (head == null) {
            throw new StackEmptyException();
        }
        return head.data;
    }

    public T pop() throws StackEmptyException {
        if (head == null) {
            throw new StackEmptyException();
        }
        T temp = head.data;
        head = head.next;
        size--;
        return temp;

    }
}
