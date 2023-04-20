package Module2.Recursion;

public class CheckIfArraySorted {
    // not an efficient way

    public static boolean isSorted(int a[]) {
        if (a.length == 1) {
            return true;
        }
        if (a[0] > a[1]) {
            return false;
        }
        int smallArray[] = new int[a.length - 1];
        for (int i = 1; i < a.length; i++) {
            smallArray[i - 1] = a[i];
        }
        boolean isSmallArraySorted = isSorted(smallArray);
        return isSmallArraySorted;

    }

    public static boolean isSortedBetter(int input[], int si) {
        if (input[si] == input.length - 1) {
            return true;
        }
        if (input[si] > input[si + 1]) {
            return false;
        }
        boolean isSmallArraySorted = isSortedBetter(input, si + 1);
        return isSmallArraySorted;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        // System.out.println(isSorted(arr));
        System.out.println(isSortedBetter(arr, 0));
    }
}
