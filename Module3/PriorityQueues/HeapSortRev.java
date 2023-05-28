package Module3.PriorityQueues;

public class HeapSortRev {
    public static void heapSortReverse(int[] arr) {
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
            int minChildIndex = parentIndex;
            if (arr[leftChildIndex] < arr[minChildIndex]) {
                minChildIndex = leftChildIndex;
            }
            if (rightChildIndex < n && arr[rightChildIndex] < arr[minChildIndex]) {
                minChildIndex = rightChildIndex;
            }
            // if both if did not work and parentindex and minchildindex is same
            // then we have found the perfect position and return
            if (minChildIndex == parentIndex) {
                return;
            }
            // now swap MinChildIndex and ParentIndex
            int temp = arr[minChildIndex];
            arr[minChildIndex] = arr[parentIndex];
            arr[parentIndex] = temp;
            // update the indices
            parentIndex = minChildIndex;
            leftChildIndex = parentIndex * 2 + 1;
            rightChildIndex = parentIndex * 2 + 2;
        }

    }

    public static void main(String[] args) {
        int arr[] = { 4, 8, 3, 6, 9, 36, 45, 7, 8, 52, 7, 5, 2, 1 };
        heapSortReverse(arr);
        for (int i : arr) {
            System.out.print(i + " ");
        }

    }
}
