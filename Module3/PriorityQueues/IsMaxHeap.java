package Module3.PriorityQueues;

public class IsMaxHeap {
    public static boolean checkMaxHeap(int arr[]) {
        /*
         * Your class should be named Solution Don't write main(). Don't read input, it
         * is passed as function argument. Return output and don't print it. Taking
         * input and printing output is handled automatically.
         */
        // PriorityQueue<Integer> pq= new PriorityQueue<>();
        int n = arr.length;
        for (int i = 0; i < n / 2; i++) {
            int LCI = 2 * i + 1;
            int RCI = 2 * i + 2;
            if (arr[i] < arr[LCI] || arr[i] < arr[RCI]) {
                return false;
            }

        }
        return true;

    }

    public static boolean checkMaxHeap1(int arr[]) {
        int n = arr.length;
        for (int i = 0; 2 * i + 1 < n; i++) {
            int leftChildIndex = 2 * i + 1;
            int rightChildIndex = leftChildIndex + 1;
            // if left child greater than parent then return false
            if (arr[i] < arr[leftChildIndex]) {
                return false;
            }
            // if right child exists and is greater than parent then return false
            if (rightChildIndex < n && arr[i] < arr[rightChildIndex]) {
                return false;
            }
        }

        return true;
    }

}
