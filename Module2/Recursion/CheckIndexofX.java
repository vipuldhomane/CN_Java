package Module2.Recursion;

public class CheckIndexofX {
    // First occurrence
    // Traversing the Array in Forward direction.
    private static int firstIndex(int arr[], int x, int si) {
        if (si == arr.length - 1) {
            return -1;

        }
        if (arr[si] == x) {
            return si;
        }
        return firstIndex(arr, x, si + 1);
    }

    public static int firstIndex(int input[], int x) {
        return firstIndex(input, x, 0);
    }
    // Last occurrence
    // Traversing the array in backward direction

    private static int lastIndex(int arr[], int x, int si) {
        si = arr.length - 1;
        if (si < 0) {
            return -1;
        }
        if (arr[si] == x) {
            return si;
        }
        int k = lastIndex(arr, x, si - 1);
        return k;
    }

    public static int lastIndex(int input[], int x) {
        return lastIndex(input, x, 0);
    }

    public static void main(String[] args) {
        int arr[] = { 10, 8, 10, 8, 10 };
        int lastind = lastIndex(arr, 10);
        System.out.println(lastind);
        int firsttind = firstIndex(arr, 10);
        System.out.println(firsttind);
    }
}
