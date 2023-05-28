package Module3.PriorityQueues.PQClass.PQmax;

import java.util.ArrayList;

public class Priority_queueMax<T> {
    ArrayList<Element<T>> heap;

    public Priority_queueMax() {
        heap = new ArrayList<>();
    }

    public void insert(T value, int priority) {
        Element<T> e = new Element<>(value, priority);
        heap.add(e);

        int childIndex = heap.size() - 1;
        int parentIndex = (childIndex - 1) / 2;

        while (childIndex > 0) {
            if (heap.get(childIndex).priority > heap.get(parentIndex).priority) {
                // swap
                Element<T> temp = heap.get(childIndex);
                heap.set(childIndex, heap.get(parentIndex));
                heap.set(parentIndex, temp);
                // update the indexes
                childIndex = parentIndex;
                parentIndex = (childIndex - 1) / 2;
            } else {
                return;
            }
        }

    }

    public T getMax() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        return heap.get(0).value;
    }

    public T removeMax() throws PriorityQueueException {
        if (isEmpty()) {
            throw new PriorityQueueException();
        }
        Element<T> removed = heap.get(0);
        T ans = removed.value;

        // add the last element to first and delete the last one
        heap.set(0, heap.get(heap.size() - 1));
        heap.remove(heap.size() - 1);
        int parentIndex = 0;
        int LCI = 2 * parentIndex + 1;
        int RCI = 2 * parentIndex + 2;
        // Run the loop till the LCI is within the array size
        // if element is in last level then it wont have the left and right child
        // it means that left child index will be out of the range of the array
        while (LCI < heap.size()) {
            int minIndex = parentIndex;
            if (heap.get(LCI).priority > heap.get(minIndex).priority) {
                minIndex = LCI;
            }
            // similar to the LCI Right child needs to in the range of the array
            // else will will cause and error
            if (RCI < heap.size() && heap.get(RCI).priority > heap.get(minIndex).priority) {
                minIndex = RCI;
            }
            // If We found the perfect spot for the element
            if (minIndex == parentIndex) {
                break;
            }
            // now we have two indexes to be swapped
            // Swap minindex and parentIndex
            Element<T> temp = heap.get(minIndex);
            heap.set(minIndex, heap.get(parentIndex));
            heap.set(parentIndex, temp);
            // update the indexes of the updated locations
            parentIndex = minIndex;
            LCI = 2 * parentIndex + 1;
            RCI = 2 * parentIndex + 2;

        }
        return ans;

    }

    public int size() {
        return heap.size();
    }

    public boolean isEmpty() {
        if (heap.size() == 0) {
            return true;
        }
        return false;
    }
}
