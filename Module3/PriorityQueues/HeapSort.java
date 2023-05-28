package Module3.PriorityQueues;

public class HeapSort {
    public static void heapSort(int[] arr) {

        // Here we are using min heap hence the results will be in the reverse order
        // to get reuslts in the increasing order we can use max heap
        // build the heap only for non-leaf elements
        int n = arr.length;
        for (int i = n / 2; i >= 0; i--) {
            downheapify(arr, i, n);
        }
        // remove element for the the start and put them at respective position
        for (int i = n - 1; i >= 0; i--) {
            // Swap [0] and last element [i]
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            downheapify(arr, 0, i);
        }
    }

    private static void downheapify(int[] arr, int i, int n) {
        // here n is length of array
        // i is starting index of array
        int parentIndex = i;
        int leftChildIndex = parentIndex * 2 + 1;
        int rightChildIndex = parentIndex * 2 + 2;

        while (leftChildIndex < n) {
            int maxChildIndex = parentIndex;
            if (arr[leftChildIndex] > arr[maxChildIndex]) {
                maxChildIndex = leftChildIndex;
            }
            if (rightChildIndex < n && arr[rightChildIndex] > arr[maxChildIndex]) {
                maxChildIndex = rightChildIndex;
            }
            // if both if did not work and parentindex and maxchildindex is same
            // then we have found the perfect position and return
            if (maxChildIndex == parentIndex) {
                return;
            }
            // now swap maxChildIndex and ParentIndex
            int temp = arr[maxChildIndex];
            arr[maxChildIndex] = arr[parentIndex];
            arr[parentIndex] = temp;
            // update the indices
            parentIndex = maxChildIndex;
            leftChildIndex = parentIndex * 2 + 1;
            rightChildIndex = parentIndex * 2 + 2;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 4, 8, 3, 6, 9, 7, 5, 2, 1 };
        heapSort(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
