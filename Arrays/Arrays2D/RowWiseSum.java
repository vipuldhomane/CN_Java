package Arrays.Arrays2D;

public class RowWiseSum {
    public static void rowWiseSum(int[][] mat) {
        // int row = mat.length;
        // int col = mat[0].length;

        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum = sum + mat[i][j];
            }
            System.out.print(sum + " ");
        }

    }

    public static void main(String[] args) {
        int arr[][] = new int[0][0];
        rowWiseSum(arr);
    }
}
