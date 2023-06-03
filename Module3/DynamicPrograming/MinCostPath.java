package Module3.DynamicPrograming;

import java.util.Arrays;

public class MinCostPath {
    public static int MinCostPathDP(int[][] input) {
        int m = input.length;
        int n = input[0].length;

        int dp[][] = new int[m + 1][n + 1];
        // initialize whole array with maxvalue
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (i == m - 1 && j == n - 1) {
                    dp[i][j] = input[i][j];
                    continue;
                }
                int ans1 = dp[i][j + 1];
                int ans2 = dp[i + 1][j];
                int ans3 = dp[i + 1][j + 1];
                dp[i][j] = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));

            }
        }
        return dp[0][0];
    }

    public static int minCostPathMemo(int[][] input, int i, int j, int[][] dp) {
        int m = input.length;
        int n = input[0].length;
        // Base case
        // when i , j is on edge such that moving right and diagonal is not possible
        // we are returning min therefore return the MAX from the rec
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        // Special case when i,j is present at the destination
        // return the value present at the i,j
        if (i == m - 1 && j == n - 1) {
            return input[i][j];
        }
        // Recursive calls
        int ans1, ans2, ans3;
        if (dp[i + 1][j] == Integer.MIN_VALUE) {
            ans1 = minCostPathMemo(input, i + 1, j, dp);
            dp[i + 1][j] = ans1;
        } else {
            ans1 = dp[i + 1][j];
        }
        if (dp[i][j + 1] == Integer.MIN_VALUE) {
            ans2 = minCostPathMemo(input, i, j + 1, dp);
            dp[i][j + 1] = ans2;
        } else {
            ans2 = dp[i][j + 1];

        }
        if (dp[i + 1][j + 1] == Integer.MIN_VALUE) {
            ans3 = minCostPathMemo(input, i + 1, j + 1, dp);
            dp[i + 1][j + 1] = ans3;
        } else {
            ans3 = dp[i + 1][j + 1];
        }

        // find minimum of the the ans and add the curr position
        int myAns = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        return myAns;
    }

    // Recursive approach
    public static int minCostPathR(int[][] input, int i, int j) {
        int m = input.length;
        int n = input[0].length;
        // Base case
        // when i , j is on edge such that moving right and diagonal is not possible
        // we are returning min therefore return the MAX from the rec
        if (i >= m || j >= n) {
            return Integer.MAX_VALUE;
        }
        // Special case when i,j is present at the destination
        // return the value present at the i,j
        if (i == m - 1 && j == n - 1) {
            return input[i][j];
        }
        // Recursive calls
        int ans1 = minCostPathR(input, i + 1, j);
        int ans2 = minCostPathR(input, i, j + 1);
        int ans3 = minCostPathR(input, i + 1, j + 1);

        // find minimum of the the ans and add the curr position
        int myAns = input[i][j] + Math.min(ans1, Math.min(ans2, ans3));
        return myAns;
    }

    public static void main(String[] args) {
        int arr[][] = { { 1, 5, 11 }, { 8, 13, 12 }, { 2, 3, 7 }, { 15, 16, 18 } };
        // maintain array larger than the original array else it will show array out of
        // bound exception
        // when execution is on the edge then it will check for the next right element
        // but it will be null
        // so it will cause error. therefore maintain the +1 size array so that when on
        // edge the next value will
        // will be min value and there wont be any problem
        int dp[][] = new int[arr.length + 1][arr[0].length + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, Integer.MIN_VALUE);
        }
        System.out.println(minCostPathMemo(arr, 0, 0, dp));
        System.out.println(minCostPathR(arr, 0, 0));
        System.out.println(MinCostPathDP(arr));
    }
}
