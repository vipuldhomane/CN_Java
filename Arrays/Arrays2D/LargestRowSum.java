package Arrays.Arrays2D;

public class LargestRowSum {
    public static void largestRowSum(int[][] mat) {
        // int row = mat.length;
        // int col = mat[0].length;
        int largest = Integer.MIN_VALUE;
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum = sum + mat[i][j];
            }
            if (sum > largest) {
                largest = sum;
            }
            System.out.print(sum + " ");
        }
        System.out.print(largest + " ");

    }

    public static void main(String[] args) {
        int arr[][] = { { 5, 2, 3 }, { 8, 3, 2 }, { 4, 1, 6 }, { 5, 6, 7 } };
        largestRowSum(arr);
    }

}
