package Arrays.Arrays2D;

public class LargestRowOrCol {
    public static void larRoworCol(int mat[][]) {

        int larRow = Integer.MIN_VALUE;
        int larCol = Integer.MIN_VALUE;
        if (mat.length == 0) {
            System.out.println("row 0" + Integer.MIN_VALUE);
            return;
        }

        // largest row sum

        int rowind = 0;
        for (int i = 0; i < mat.length; i++) {
            int sum = 0;
            for (int j = 0; j < mat[0].length; j++) {
                sum += mat[i][j];
            }
            if (sum > larRow) {
                larRow = sum;
                rowind = i;
            }
        }
        // largest col
        int colind = 0;
        for (int j = 0; j < mat[0].length; j++) {
            int sum = 0;
            for (int i = 0; i < mat.length; i++) {
                sum += mat[i][j];
            }
            if (sum > larCol) {
                larCol = sum;
                colind = j;
            }
        }
        if (larCol > larRow) {
            System.out.println("column " + colind + " " + larCol);
        } else {

            System.out.println("row " + rowind + " " + larRow);
        }
    }

    public static void main(String[] args) {
        // int mat[][] = { { 20, 2, 3 }, { 4, 5, 6 }, { 7, 4, 5 } };
        int mat[][] = {};
        larRoworCol(mat);
    }
}
