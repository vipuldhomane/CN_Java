package Module3.Recursion3;

public class MinInArray {
    public static void minArray(int a[], int si, int min) {
        if (si == a.length) {
            System.out.println(min);
            return;

        }
        int newmin = min;
        if (a[si] < min) {
            newmin = a[si];
        }
        minArray(a, si + 1, newmin);
    }

    public static void main(String[] args) {
        int arr[] = { 74, 25, 41, 52, 65, 41, 65, 41, 63 };
        minArray(arr, 0, Integer.MAX_VALUE);
    }
}
