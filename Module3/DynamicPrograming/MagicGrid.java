package Module3.DynamicPrograming;

public class MagicGrid {
    public static int getMinimumStrengthRC(int[][] grid) {
        int R = grid.length;
        int C = grid[0].length;
        return getMin(grid, 0, 0, R, C);
    }

    private static int getMin(int[][] grid, int i, int j, int row, int col) {
        // base case we are present on the last cell
        if (i == row - 1 && j == col - 1) {
            return Math.max(1, 1 - grid[i][j]);
        }
        // base case 2 if we are on last row
        if (i == row - 1) {
            return Math.max(1, getMin(grid, i, j + 1, row, col) - grid[i][j]);
        }
        // base cae 3 if we are on last row and there is no cell to traverese in the
        // right direction
        if (j == col - 1) {
            return Math.max(1, getMin(grid, i + 1, j, row, col) - grid[i][j]);
        }
        // if all of this cases does not meet then do recursion on right and down and
        // return minimum
        int down = Math.max(1, getMin(grid, i + 1, j, row, col) - grid[i][j]);
        int right = Math.max(1, getMin(grid, i, j + 1, row, col) - grid[i][j]);
        return Math.min(down, right);
    }

    // Cn Sol
    public static int getMinimumStrengthDP(int[][] grid) {
        /*
         * dp[i][j] stores the minimum strength required to reach
         * bottom right corner of grid from the index (i, j)
         */
        int n = grid.length;
        int m = grid[0].length;
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 0; i <= n; ++i) {
            for (int j = 0; j <= m; ++j) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        dp[n][m - 1] = 1;
        dp[n - 1][m] = 1;

        for (int i = n - 1; i >= 0; --i) {

            for (int j = m - 1; j >= 0; --j) {
                // 'neededStrength' stores the minimum strength needed to survive
                int neededStrength = Integer.min(dp[i + 1][j], dp[i][j + 1]) - grid[i][j];
                dp[i][j] = (neededStrength <= 0) ? 1 : neededStrength;
            }
        }
        int ans = dp[0][0];
        return ans;
    }

    public static int getMinimumStrength1(int[][] grid) {

        int row = grid.length;
        if (row == 0)
            return row;

        int col = grid[0].length;
        if (col == 0)
            return col;

        int[][] dp = new int[row][col];
        dp[row - 1][col - 1] = 1;

        for (int i = col - 2; i >= 0; i--) {
            dp[row - 1][i] = dp[row - 1][i + 1] - grid[row - 1][i];

        }
        for (int i = row - 2; i >= 0; i--) {
            dp[i][col - 1] = dp[i + 1][col - 1] - grid[i][col - 1];
        }

        for (int i = row - 2; i >= 0; i--) {
            for (int j = col - 2; j >= 0; j--) {
                int ans1 = dp[i + 1][j];
                int ans2 = dp[i][j + 1];

                dp[i][j] = Math.max(1, Math.min(ans1, ans2) - grid[i][j]);
            }
        }

        return dp[0][0];

    }

    public static void main(String[] args) {
        int[][] grid = {
                { 1, -2, 3 },
                { 2, -1, 0 },
                { -3, -1, 1 }
        };
        int minimumStrength = getMinimumStrengthRC(grid);
        System.out.println("Minimum strength points required: " + minimumStrength);
        System.out.println(getMinimumStrengthDP(grid));
    }
}
/*
 * Recursive expplaination
 * Certainly! Let's walk through the approach step by step:
 * 
 * We start by defining a recursive function called minStrengthPoints. This
 * function takes the following parameters:
 * 
 * grid: the magic grid
 * i: current row index
 * j: current column index
 * R: total number of rows
 * C: total number of columns
 * The first base case in the minStrengthPoints function is when we reach the
 * bottom-right cell, which is the destination. If the current cell is the last
 * cell in the grid (i == R - 1 and j == C - 1), we return the maximum of 1 and
 * the difference between 1 and the strength points in the current cell (1 -
 * grid[i][j]). This ensures that we always have at least 1 strength point left
 * when reaching the destination.
 * 
 * The second base case is when we reach the last row but not the last column.
 * In this case, we can only move right to reach the destination. We recursively
 * calculate the minimum strength points required to reach the destination cell
 * by moving right (minStrengthPoints(grid, i, j + 1, R, C)), subtract the
 * strength points in the current cell (grid[i][j]), and take the maximum
 * between the result and 1. This ensures that we always have at least 1
 * strength point left in each step.
 * 
 * The third base case is similar to the second base case, but it occurs when we
 * reach the last column but not the last row. In this case, we can only move
 * down to reach the destination. We recursively calculate the minimum strength
 * points required to reach the destination cell by moving down
 * (minStrengthPoints(grid, i + 1, j, R, C)), subtract the strength points in
 * the current cell (grid[i][j]), and take the maximum between the result and 1.
 * 
 * For the recursive cases, we consider two options:
 * 
 * Moving right: We calculate the minimum strength points required by moving
 * right. We recursively call the minStrengthPoints function with the next
 * column index (j + 1), subtract the strength points in the current cell
 * (grid[i][j]), and take the maximum between the result and 1.
 * Moving down: We calculate the minimum strength points required by moving
 * down. We recursively call the minStrengthPoints function with the next row
 * index (i + 1), subtract the strength points in the current cell (grid[i][j]),
 * and take the maximum between the result and 1.
 * Finally, in each step, we return the minimum of the two options (moving right
 * or down) as the overall minimum strength points required to reach the
 * destination cell.
 * 
 * By exploring all possible paths from the top-left to the bottom-right cell
 * using the recursive function, we can find the minimum strength points
 * required to reach the destination while avoiding a strength point value of
 * zero or less at any point.
 */
