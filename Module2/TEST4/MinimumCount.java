package Module2.TEST4;

public class MinimumCount {
    public static int minCount(int n) {
        // Base case: if n is 0 or 1, return n
        if (n <= 1) {
            return n;
        }
        // Initialize the result as the maximum possible value
        int result = Integer.MAX_VALUE;
        // Loop from 1 to the square root of n
        for (int i = 1; i * i <= n; i++) {
            // Recursively find the minimum count for n - i^2 and add 1
            int subResult = minCount(n - i * i) + 1;
            // Update the result if subResult is smaller
            result = Math.min(result, subResult);
        }
        // Return the final result
        return result;
    }

    // Without recursion
    public static int minCount1(int n) {
        // Create an array to store the results for subproblems
        int[] dp = new int[n + 1];
        // Initialize the base case: dp[0] = 0 and dp[1] = 1
        dp[0] = 0;
        dp[1] = 1;
        // Loop from 2 to n
        for (int i = 2; i <= n; i++) {
            // Initialize the result as the maximum possible value
            dp[i] = Integer.MAX_VALUE;
            // Loop from 1 to the square root of i
            for (int j = 1; j * j <= i; j++) {
                // Update the result if dp[i - j^2] + 1 is smaller
                dp[i] = Math.min(dp[i], dp[i - j * j] + 1);
            }
        }
        // Return the final result
        return dp[n];
    }
}
