package Arrays;

import java.util.*;

public class linearSearch {
    public static int[] takeinput() {
        Scanner sc = new Scanner(System.in);
        System.out.println("Declare size of Array");
        int n = sc.nextInt();
        int arr[] = new int[n];

        for (int i = 0; i < n; i++) {
            System.out.print("Enter the Value at " + i + "th index: ");
            arr[i] = sc.nextInt();
        }
        // sc.close();
        return arr;
    }

    public static int linearSearch(int arr[], int x) {
        int index = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == x) {
                index = i;
                break;
            }
        }
        return index;
    }

    public static void main(String[] args) {
        int array[] = takeinput();
        int search = linearSearch(array, 15);
        System.out.println(search);
    }
}
