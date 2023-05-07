package Module2.Stacks;

import java.util.LinkedList;
import java.util.Queue;

public class StackUsing2Queue {

    // Define the data members
    Queue<Integer> q1;
    Queue<Integer> q2;
    int size;

    public StackUsing2Queue() {
        // Implement the Constructor
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        size = 0;
    }

    /*----------------- Public Functions of Stack -----------------*/

    public int getSize() {
        // Implement the getSize() function
        return size;
    }

    public boolean isEmpty() {
        // Implement the isEmpty() function
        return size == 0;
    }

    public void push(int element) {
        // Implement the push(element) function
        q1.add(element);
        size++;
    }

    public int pop() {
        // Implement the pop() function
        if (isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int ans = q1.remove();
        while (q2.size() > 0) {
            q1.add(q2.remove());
        }
        size--;
        return ans;
    }

    public int top() {
        // Implement the top() function
        if (isEmpty()) {
            return -1;
        }
        while (q1.size() > 1) {
            q2.add(q1.remove());
        }
        int ans = q1.peek();
        q2.add(q1.remove());
        while (q2.size() > 0) {
            q1.add(q2.remove());
        }
        return ans;
    }
}