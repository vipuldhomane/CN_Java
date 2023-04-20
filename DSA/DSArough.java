package DSA;

import java.util.Arrays;

public class DSArough {
    public static void main(String[] args) {
        int arr[] = { 6, -8, 4, 1, -6, 2, -2, 15 };
        Arrays.sort(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println(arr.length);
        System.out.println(arr[arr.length - 1]);
    }
}
