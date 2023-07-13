package Arrays.Algo;

public class SelectionSort {
    public static void selectionSort(int arr[]) {
        int n = arr.length;
        // No of rounds = n-1
        for (int i = 0; i < (n - 1); i++) {
            int min = Integer.MAX_VALUE;
            int minindex = -1;
            for (int j = i; j < n; j++) {
                if (arr[j] < min) {
                    min = arr[j];
                    minindex = j;
                }
            }
            // Exchanging values of minindex with ith variable
            int temp = arr[minindex];
            arr[minindex] = arr[i];
            arr[i] = temp;

        }
    }

    public static void readarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = { 3, 5, 2, 7, 9, 0, 7, 6, 5, 4, 3, 4, 5, 6, 7 };
        selectionSort(array);
        readarray(array);
    }
}
