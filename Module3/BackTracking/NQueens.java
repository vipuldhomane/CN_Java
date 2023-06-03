package Module3.BackTracking;

public class NQueens {
    /*
     * You are given N, and for a given N x N chessboard, find a way to place N
     * queens such that no queen can attack any other queen on the chess board. A
     * queen can be killed when it lies in the same row, or same column, or the same
     * diagonal of any of the other queens. You have to print all such
     * configurations.
     * 
     * Input Format :
     * Line 1 : Integer N
     * 
     * Output Format :
     * One Line for every board configuration.
     * Every line will have N*N board elements printed row wise and are separated by
     * space
     * Note : Don't print anything if there isn't any valid configuration.
     * 
     * Constraints :
     * 1<=N<=10
     * 
     * Sample Input 1:
     * 4
     * Sample Output 1 :
     * 0 1 0 0 0 0 0 1 1 0 0 0 0 0 1 0
     * 0 0 1 0 1 0 0 0 0 0 0 1 0 1 0 0
     */

    public static void placeNQueens(int n) {

        /*
         * Your class should be named Solution.
         * Don't write main() function.
         * Don't read input, it is passed as function argument.
         * Print output as specified in the question
         */
        int[][] board = new int[n][n];
        solveNQueens(board, 0, n);

    }

    static void solveNQueens(int board[][], int row, int N) {
        /*
         * base case: If all queens are placed
         * then return true
         */
        if (row == N) {
            printSolution(board, N);
            return;
        }

        /*
         * Consider this column and try placing
         * this queen in all rows one by one
         */
        for (int i = 0; i < N; i++) {
            /*
             * Check if queen can be placed on
             * board[row][i]
             */
            if (isSafe(board, row, i, N)) {
                /* Place this queen in board[row][i] */
                board[row][i] = 1;

                // Make result true if any placement
                // is possible
                solveNQueens(board, row + 1, N);

                /*
                 * If placing queen in board[row][i]
                 * doesn't lead to a solution, then backtrack and
                 * remove queen from board[row][i]
                 */
                board[row][i] = 0;
            }
        }

    }

    static boolean isSafe(int board[][], int row, int col, int N) {
        int i, j;

        // Check if all values in the given column and rows from 0 to row-1 are 0
        for (i = 0; i < row; i++) {
            if (board[i][col] == 1)
                return false;
        }

        // Check upper diagonal on left side
        for (i = row, j = col; i >= 0 && j >= 0; i--, j--)
            if (board[i][j] == 1)
                return false;

        // Check upper right diagonal
        for (i = row, j = col; i >= 0 && j < N; i--, j++)
            if (board[i][j] == 1)
                return false;

        return true;
    }

    static void printSolution(int board[][], int N) {
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < N; j++)
                System.out.print(board[i][j] + " ");
            System.out.println();
        }
        System.out.println();
    }

    // CN
    public static void placeNQueensCN(int n) {
        int board[][] = new int[n][n];
        placeQueen(board, 0, n);
    }

    private static void placeQueen(int[][] board, int row, int n) {
        if (row == n) {
            // for (int i = 0; i < n; i++) {
            // for (int j = 0; j < n; j++) {
            // System.out.print(board[i][j] + " ");
            // }
            // System.out.println();
            // }
            printSolution(board, n);
            System.out.println();
            return;
        }
        for (int j = 0; j < n; j++) {
            if (isBoardSafe(board, row, j)) {
                board[row][j] = 1;
                placeQueen(board, row + 1, n);
                board[row][j] = 0;
            }
        }
    }

    private static boolean isBoardSafe(int board[][], int row, int col) {
        int n = board.length;
        // Top left diagonal
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // Down Right
        for (int i = row + 1, j = col + 1; i < n && j < n; i++, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // top right
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // down left
        for (int i = row + 1, j = col - 1; i < n && j >= 0; i++, j--) {
            if (board[i][j] == 1) {
                return false;
            }
        }
        // top
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][col] == 1) {
                return false;
            }
        }
        // down
        for (int i = row + 1; i < n; i++) {
            if (board[i][col] == 1) {
                return false;
            }
        }

        return true;
    }

    public static void main(String[] args) {
        placeNQueens(4);
    }

}
