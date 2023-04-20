package Arrays;

import java.util.Scanner;

public class arr_basicsFUN {
    // Taking inputs in array
    public static int[] takeinput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Declare size of Array");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Value at " + i + "th index: ");
            arr[i] = sc.nextInt();
        }
        return arr;
    }

    // Reading the Elements in Array
    public static void readarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    // Sum of an Array:
    public static int sumArray(int arr[]) {
        int s = 0;
        for (int i = 0; i < arr.length; i++) {
            s += arr[i];
        }
        return s;
    }

    public static void main(String[] args) {
        int empArray[] = {};
        // int arr1[] = takeinput();

        // readarray(arr1);

        // System.out.println(sumArray(arr1));

        readarray(empArray);
    }
}
