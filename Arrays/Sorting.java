package Arrays;

import java.util.*;

public class Sorting {
    public static void readarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void Sort(int arr[]) {
        Arrays.sort(arr);
    }

    public static void main(String[] args) {
        int array[] = { 0, 1, 0, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 1, 0, 1, 0, 1, 0 };
        // int sort[]= Array.sort
        Sort(array);
        readarray(array);

    }
}
