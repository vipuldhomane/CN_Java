package Arrays.Algo;

public class BubbleSort {
    public static void bubbleSort(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }

    public static void readarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = { 4, 3, 6, 8, 1, 5, 7, 44, 0, 1, 0, 2, 0, 6, 21, 1, 2, 25, 13 };
        bubbleSort(array);
        readarray(array);
    }
}
