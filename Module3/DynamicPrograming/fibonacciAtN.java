package Module3.DynamicPrograming;

/**
 * fibonachhiAtN
 */
public class fibonacciAtN {
    public static int fibAtNIterative(int n) {
        // The most optimal solution for fibonacci
        if (n == 0 || n == 1) {
            return n;
        }
        int dp[] = new int[n + 1];
        dp[0] = 0;
        dp[1] = 1;

        // n>=2;
        for (int i = 2; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    public static int fibAtN(int n, int dp[]) {
        // base case
        if (n == 0 || n == 1) {
            return n;
        }
        int ans1, ans2;
        if (dp[n - 1] == -1) {
            ans1 = fibAtN(n - 1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }
        if (dp[n - 2] == -1) {
            ans2 = fibAtN(n - 2, dp);
            dp[n - 2] = ans2;
        } else {
            ans2 = dp[n - 2];
        }
        int myAns = ans1 + ans2;
        return myAns;
    }

    public static void main(String[] args) {
        int n = 30;
        int dp[] = new int[n + 1];
        for (int i = 0; i < dp.length; i++) {
            dp[i] = -1;
        }
        System.out.println(fibAtN(n, dp));

        System.out.println(fibAtNIterative(30));
    }
}