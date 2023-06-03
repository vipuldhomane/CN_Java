package DSA;

public class ReverseArray {
    public static void reverese(int arr[], int i, int j) {
        while (i < j) {
            int temp = arr[i];
            arr[j] = arr[i];
            arr[i] = temp;
            i++;
            j--;
        }

    }

    public static void reverseArray(int arr[]) {
        int start = 0;
        int end = arr.length - 1;
        while (start < end) {
            int temp = arr[start];
            arr[start] = arr[end];
            arr[end] = temp;
            start++;
            end--;

        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        reverseArray(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }

    }
}
