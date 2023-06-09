package Module3.DynamicPrograming;

public class MaxSubSqMatrix {
    public static int findMaxSquareWithAllZerosRC(int[][] input) {
        int row = input.length;
        int col = input[0].length;
        int maxSize = 0;
        int memo[][] = new int[row + 1][col + 1];
        for (int i = 1; i <= row; i++) {
            for (int j = 1; j <= col; j++) {
                maxSize = Math.max(maxSize, findMaxSubMat(input, i, j, memo));
            }
        }
        return maxSize;

    }

    private static int findMaxSubMat(int[][] input, int i, int j, int[][] memo) {
        if (i <= 0 || j <= 0 || input[i - 1][j - 1] == 1) {
            return 0;
        }
        if (memo[i][j] != 0) {
            return memo[i][j];
        }
        // run recursion on 3 directions top, left and diagonal
        int ans1, ans2, ans3;
        if (memo[i - 1][j] != 0) {
            ans1 = findMaxSubMat(input, i - 1, j, memo);
            memo[i - 1][j] = ans1;
        } else {
            ans1 = memo[i - 1][j];
        }
        if (memo[i][j - 1] != 0) {
            ans2 = findMaxSubMat(input, i, j - 1, memo);
            memo[i][j - 1] = ans2;
        } else {
            ans2 = memo[i][j - 1];
        }
        if (memo[i - 1][j - 1] != 0) {
            ans3 = findMaxSubMat(input, i - 1, j - 1, memo);
            memo[i - 1][j - 1] = ans3;
        } else {
            ans3 = memo[i - 1][j - 1];
        }
        // return 1 + min
        int ans = 1 + Math.min(ans2, Math.min(ans1, ans3));
        memo[i][j] = ans;
        return ans;
    }

    // DP
    public static int findMaxSquareWithAllZeros(int[][] input) {
        int max = 0;
        if (input.length == 0) {
            return 0;
        }
        int[][] array = new int[input.length][input[0].length];

        for (int i = 0; i < input.length; i++) {
            if (input[i][0] == 0) {
                array[i][0] = 1;
                max = 1;
            } else
                array[i][0] = 0;
        }

        for (int j = 0; j < input[0].length; j++) {
            if (input[0][j] == 0) {
                array[0][j] = 1;
                max = 1;
            } else
                array[0][j] = 0;
        }

        for (int i = 1; i < input.length; i++) {
            for (int j = 1; j < input[0].length; j++) {
                if (input[i][j] == 1) {
                    array[i][j] = 0;
                } else {
                    array[i][j] = 1 + Math.min(array[i - 1][j - 1], Math.min(array[i][j - 1], array[i - 1][j]));
                    if (array[i][j] > max) {
                        max = array[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static int MaxSubSet(int[][] input) {
        int max = 0;
        if (input.length == 0) {
            return 0;
        }
        int m = input.length;
        int n = input[0].length;
        int dp[][] = new int[m][n];
        // Traverse on the first row
        for (int i = 0; i < m; i++) {
            if (input[i][0] == 0) {
                dp[i][0] = 1;
                max = 1;
            } else {
                dp[i][0] = 0;
            }
        }
        // traverse on the first row
        for (int j = 0; j < n; j++) {
            if (input[0][j] == 0) {
                dp[0][j] = 1;
                max = 1;
            } else {
                dp[0][j] = 0;
            }
        }
        // now traverse form the i+1 j+1
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                if (input[i][j] == 1) {
                    dp[i][j] = 0;
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], Math.min(dp[i][j - 1], dp[i - 1][j - 1]));
                    if (dp[i][j] > max) {
                        max = dp[i][j];
                    }
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        int[][] matrix = {
                { 0, 0, 0 },
                { 0, 0, 1 },
                { 0, 0, 0 }
        };
        System.out.println(findMaxSquareWithAllZerosRC(matrix));
        System.out.println(MaxSubSet(matrix));

    }

}
