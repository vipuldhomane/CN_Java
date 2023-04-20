package Arrays.Arrays2D;

public class LargestColSum {
    public static int largestCol(int[][] arr) {
        int rows = arr.length;
        int cols = arr[0].length;
        int largest = Integer.MIN_VALUE;
        // iterating on each columns
        for (int j = 0; j < cols; j++) {
            int sum = 0;
            for (int i = 0; i < rows; i++) {
                sum = sum + arr[i][j];
            }
            if (sum > largest) {
                largest = sum;
            }
        }
        return largest;
    }

    public static void main(String[] args) {
        int[][] arr = { { 2, 9, 6 }, { 7, 8, 0 }, { 1, 2, 1 } };
        System.out.println(largestCol(arr));
    }
}
