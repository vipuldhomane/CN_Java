package Module2.Recursion;

// Cn Solution
public class ArraySum {

    public static int sum(int input[], int startIndex) {
        if (startIndex == input.length) {
            return 0;
        }
        return input[startIndex] + sum(input, startIndex + 1);
    }

    public static int sum(int input[]) {
        return sum(input, 0);
    }
    // CN Sol End

    public static int sum1(int arr[], int si) {
        if (si >= arr.length) {
            return 0;
        }
        int sum = arr[si] + sum1(arr, si + 1);
        return sum;

    }

    public static int arraySum(int input[]) {
        return sum1(input, 0);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5 };
        System.out.println(arraySum(arr));
    }
}