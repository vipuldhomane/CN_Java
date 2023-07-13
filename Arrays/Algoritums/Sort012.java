package Arrays.Algo;

public class Sort012 {

    public static void sort012(int[] arr) {

        int j = 0;
        int k = arr.length - 1;
        int i = 0;

        while (i <= k) {

            if (arr[i] == 0) {
                // swap
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
                // increment
                i++;
                j++;

            } else if (arr[i] == 2) {
                // Swap
                int temp = arr[k];
                arr[k] = arr[i];
                arr[i] = temp;
                // decrement
                k--;

            } else {
                i++;
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
        int array[] = { 1, 0, 2, 0, 1, 0, 2, 1, 0, 2, 1, 0, 2, 1, 0, 2 };
        sort012(array);
        readarray(array);
    }
}