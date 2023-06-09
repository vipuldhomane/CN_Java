package Module3.DynamicPrograming;

public class CoinChange {
    public static int helper(int deno[], int value, int i) {
        if (value == 0) {
            // means we have found the change
            return 1;
        }
        // if value goes below zero or array finished
        if (value < 0 || i >= deno.length) {
            return 0;
        }
        // Recursive calls
        // including
        int ans1 = helper(deno, value - deno[i], i);
        int ans2 = helper(deno, value, i + 1);
        return ans1 + ans2;
    }

    public static int countWaysToMakeChange(int denominations[], int value) {
        return helper(denominations, value, 0);
    }
    // memo

    public static int helperMemo(int deno[], int value, int i, int[][] memo) {

        if (value == 0) {
            // means we have found the change
            return 1;
        }
        // if value goes below zero or array finished
        if (value < 0 || i >= deno.length) {
            return 0;
        }
        if (memo[i][value] != 0) {
            return memo[i][value];
        }
        // Recursive calls
        // including
        int ans1 = helperMemo(deno, value - deno[i], i, memo);
        int ans2 = helperMemo(deno, value, i + 1, memo);
        int totalWays = ans1 + ans2;
        memo[i][value] = totalWays;
        return totalWays;
    }

    // Dp Code using 1d Array
    public static int countWaysToMakeChangeDP(int denominations[], int value) {
        // initialize 1d array of value +1
        int[] dp = new int[value + 1];
        dp[0] = 1;
        // run a loop on denominations array
        // and one inner loop starting from the coin to value
        for (int coin : denominations) {
            for (int i = coin; i <= value; i++) {
                // set the answers in the array
                // add the value of i-coin to original place
                dp[i] += dp[i - coin];
            }
        }
        return dp[value];

    }

    public static int countWaysToMakeChangeMemo(int denominations[], int value) {
        int memo[][] = new int[denominations.length + 1][value + 1];
        return helperMemo(denominations, value, 0, memo);

    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4 };
        int val = 40;
        System.out.println(countWaysToMakeChange(arr, val));
        System.out.println(countWaysToMakeChangeMemo(arr, val));
        System.out.println(countWaysToMakeChangeDP(arr, val));
    }
}
