package Module2.Recursion2;

public class BinarySearch {
    public static int binarySearch(int arr[], int si, int ei, int x) {
        if (si > ei) {
            return -1;
        }
        int midIndex = (si + ei) / 2;
        if (arr[midIndex] == x) {
            return midIndex;
        } else if (arr[midIndex] < x) {
            return binarySearch(arr, midIndex + 1, ei, x);

        } else {
            return binarySearch(arr, si, midIndex - 1, x);
        }
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 8, 9 };
        System.out.println(binarySearch(arr, 0, arr.length - 1, 8));
    }
}
