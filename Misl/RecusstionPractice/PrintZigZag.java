package RecusstionPractice;

public class PrintZigZag {
    public static void printZigZag(int n) {
        if (n == 0) {
            return;

        }
        System.out.print(n + " ");
        printZigZag(n - 1);
        System.out.print(n + " ");
        printZigZag(n - 1);
        System.out.print(n + " ");

    }

    public static int firstIndex(int arr[], int ind, int n) {
        if (ind == arr.length) {
            return -1;

        }
        if (arr[ind] == n) {
            return ind;

        }
        int smallOutput = firstIndex(arr, ind + 1, n);
        return smallOutput;
    }

    public static int lastIndex(int arr[], int ind, int n) {
        if (ind == -1) {
            return -1;

        }
        if (arr[ind] == n) {
            return ind;

        }
        int smallOutput = lastIndex(arr, ind - 1, n);
        return smallOutput;
    }

    public static void main(String[] args) {
        // printZigZag(2);
        int arr[] = { 4, 5, 2, 7, 3, 7, 6, 9, 8 };
        System.out.println(lastIndex(arr, arr.length - 1, 7));
        System.out.println(firstIndex(arr, 0, 7));
    }
}
