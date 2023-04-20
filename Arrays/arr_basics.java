package Arrays;

import java.util.Scanner;

public class arr_basics {
    public static void main(String[] args) {
        // Declaring an Array
        int arr[] = new int[10];
        // adding elements to the array
        // arr[0] = 454;
        System.out.println(arr[0]);

        // adding Multiple elements at once using loops
        Scanner sc = new Scanner(System.in);
        System.out.println("Declare size of Array");
        int n = sc.nextInt();
        for (int i = 0; i < n; i++) {
            System.out.println("Enter Value at" + i + "th Index");
            arr[i] = sc.nextInt();
        }

        // Reading the elements of an Array using loop
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
