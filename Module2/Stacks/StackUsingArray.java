package Module2.Stacks;

public class StackUsingArray {
    private int data[];
    private int topIndex;

    public StackUsingArray() {
        data = new int[10];
        topIndex = -1;
    }

    public StackUsingArray(int size) {
        data = new int[size];
        topIndex = -1;
    }

    public int size() {
        return topIndex + 1;

    }

    public boolean isEmpty() {
        // if (topIndex == -1) {
        // return false;
        // }
        // return true;
        return topIndex == -1;
    }

    public void push(int elem) throws StackFullException {
        if (topIndex == data.length - 1) {
            // StackFullException e = new StackFullException();
            // throw e;
            doubleCapacity();
        }
        topIndex++;
        data[topIndex] = elem;
    }

    private void doubleCapacity() {
        // System.out.println("double");
        int temp[] = data;
        data = new int[temp.length * 2];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    public int top() throws StackEmptyException {
        if (topIndex == -1) {
            throw new StackEmptyException();
        }
        return data[topIndex];
    }

    public int pop() throws StackEmptyException {
        if (topIndex == -1) {
            throw new StackEmptyException();
        }
        int temp = data[topIndex];
        topIndex--;
        return temp;
    }

}
