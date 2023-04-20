package Arrays;

import java.util.Scanner;

public class LargestNumArray {
    public static int maxNumArray(int arr[]) {
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > max) {
                max = arr[i];
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int array[] = { 4, 1, 5, 2, 7, 5, 6, 9, 5 };
        System.out.println(maxNumArray(array));

    }
}
