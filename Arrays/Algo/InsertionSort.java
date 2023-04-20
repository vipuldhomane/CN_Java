package Arrays.Algo;

public class InsertionSort {
    public static void insertionSort(int arr[]) {
        int n = arr.length;

        for (int i = 1; i < n; i++) {
            int temp = arr[i];
            int j = i - 1;
            // j>= zero is imp
            while (j >= 0 && arr[j] > temp) {
                // If arr[j] > temp(arr[i]) then replace arr[j] with position of temp
                // by doing this temp will take the position of j
                // in next iteration j will reduce by 1 and loop will continue
                arr[j + 1] = arr[j];
                j--;
            }
            // Final Position will be J+1:
            // arr[j] is less or equal to temp then replace with temp
            arr[j + 1] = temp;
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
        insertionSort(array);
        readarray(array);

    }

}
