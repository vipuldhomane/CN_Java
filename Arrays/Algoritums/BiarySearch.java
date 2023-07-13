
package Arrays.Algo;

import java.util.*;

public class BiarySearch {
    public static int BinarySearch(int arr[], int x) {
        Arrays.sort(arr);
        int n = arr.length;
        int start = 0;
        int end = n - 1;

        // int mid = -1;
        while (start <= end) {
            int mid = (start + end) / 2;
            if (arr[mid] > x) {
                end = mid - 1;
            } else if (arr[mid] < x) {
                start = mid + 1;
            } else {
                return mid;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int array[] = { 1, 3, 5, 7, 20, 25, 29 };
        System.out.println(BinarySearch(array, 20));
    }
}
