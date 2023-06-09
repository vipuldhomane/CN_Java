package Module3.DynamicPrograming;

public class Knapsack {
    public static int knapsack(int[] weights, int[] values, int n, int maxWeight) {
        int[][] dp = new int[n + 1][maxWeight + 1];

        for (int i = n - 1; i >= 0; i--) {
            for (int w = 0; w <= maxWeight; w++) {
                int ans;
                if (weights[i] <= w) {
                    int ans1 = values[i] + dp[i + 1][w - weights[i]];
                    int ans2 = dp[i + 1][w];
                    ans = Math.max(ans1, ans2);
                } else {
                    ans = dp[i + 1][w];
                }
                dp[i][w] = ans;
            }
        }
        return dp[0][maxWeight];
    }

    public static int knapsackRC(int[] weights, int[] values, int i, int n, int maxWeight) {
        // Your code goes here
        if (i == values.length) {
            return 0;
        }
        int ans;
        if (weights[i] <= maxWeight) {
            // including
            int ans1 = values[i] + knapsackRC(weights, values, i + 1, n - 1, maxWeight - weights[i]);

            int ans2 = knapsackRC(weights, values, i + 1, n - 1, maxWeight);
            ans = Math.max(ans1, ans2);

        } else {
            ans = knapsackRC(weights, values, i + 1, n - 1, maxWeight);

        }
        return ans;
    }

    public static void main(String[] args) {
        int[] weights = { 1, 2, 4, 5 };
        int[] value = { 5, 4, 8, 6 };
        int wt = 5;
        System.out.println(knapsackRC(weights, value, 0, value.length, wt));
        System.out.println(knapsack(weights, value, value.length, wt));
    }
}
