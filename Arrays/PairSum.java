package Arrays;

/**
 * PairSum
 */
public class PairSum {

    public static int pairSum(int arr[], int x) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] + arr[j] == x) {
                    count += 1;
                }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int array[] = { 4, 5, 8, 6, 4, 7, 9 };
        System.out.println(pairSum(array, 10));
    }
}
