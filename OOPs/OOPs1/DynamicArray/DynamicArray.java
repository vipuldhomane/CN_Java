package OOPs.OOPs1.DynamicArray;

public class DynamicArray {
    private int data[];
    private int nextElementIndex;

    public DynamicArray() {
        data = new int[5];
        nextElementIndex = 0;
    }

    public int size() {
        return nextElementIndex;
    }

    public boolean isEmpty() {
        return nextElementIndex == 0;
    }

    public int get(int i) {
        if (i >= nextElementIndex) {
            return -1;
        }
        return data[i];
    }

    public void set(int i, int Element) {
        if (i >= nextElementIndex) {
            return;
        }
        data[i] = Element;
    }

    public void add(int Element) {
        if (nextElementIndex == data.length) {
            doubleCapacity();
        }
        data[nextElementIndex] = Element;
        nextElementIndex++;
    }

    private void doubleCapacity() {
        int temp[] = data;
        data = new int[2 * temp.length];
        for (int i = 0; i < temp.length; i++) {
            data[i] = temp[i];
        }
    }

    public int removeLast() {
        int temp = nextElementIndex - 1;
        data[nextElementIndex] = 0;
        nextElementIndex--;
        return temp;
    }

}
