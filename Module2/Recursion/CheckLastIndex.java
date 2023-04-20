package Module2.Recursion;

public class CheckLastIndex {
    // Forward Traverse
    private static int lastIndexForward(int input[], int x, int si) {
        if (si == input.length) {
            return -1;
        }
        int k = lastIndexForward(input, x, si + 1);
        if (k != -1) {
            return k;
        } else if (input[si] == x) {
            return si;
        } else {
            return -1;
        }

    }

    public static int lastIndexForward(int input[], int x) {
        return lastIndexForward(input, x, 0);

    }

    // // Backward Traverse
    // private static int lastIndex(int arr[], int x, int si) {
    // // si = arr.length - 1;
    // if (si < 0) {
    // return -1;
    // }
    // if (arr[si] == x) {
    // return si;
    // }
    // int k = lastIndex(arr, x, si - 1);
    // return k;
    // }

    // public static int lastIndex(int input[], int x) {
    // // return lastIndex(input, x, 0);
    // return lastIndex(input, x, input.length - 1);
    // }

    public static void main(String[] args) {
        int arr[] = { 9, 9, 10, 9, 9, 9, 10 };
        System.out.println(lastIndexForward(arr, 10));
    }
}
