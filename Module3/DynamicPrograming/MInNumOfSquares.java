package Module3.DynamicPrograming;

public class MInNumOfSquares {
    public static int minSquaresIterative(int n) {
        // initializing the array
        int dp[] = new int[n + 1];
        // base case
        dp[0] = 0;
        for (int i = 1; i <= n; i++) {
            int minAns = Integer.MAX_VALUE;
            for (int j = 1; j * j <= i; j++) {
                int currAns = dp[i - (j * j)];
                if (currAns < minAns) {
                    minAns = currAns;
                }
            }
            dp[i] = 1 + minAns;
        }
        return dp[n];
    }

    public static int minSquaresRC(int n) {
        if (n == 0) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        // we want to find till n-i^2
        // run a loop from 1 to i^2
        for (int i = 1; i * i <= n; i++) {
            int currAns = minSquaresRC(n - (i * i));
            if (currAns < minAns) {
                minAns = currAns;
            }
        }
        return minAns + 1;
    }

    public static int minSquaresDp(int n, int[] dp) {
        if (n == 0) {
            return 0;
        }
        int minAns = Integer.MAX_VALUE;
        // we want to find till n-i^2
        // run a loop from 1 to i^2
        for (int i = 1; i * i <= n; i++) {
            int currAns;
            if (dp[n - (i * i)] == -1) {
                currAns = minSquaresDp(n - (i * i), dp);
                dp[n - (i * i)] = currAns;

            } else {
                currAns = dp[n - (i * i)];
            }
            if (currAns < minAns) {
                minAns = currAns;
            }
        }
        return minAns + 1;
    }

    public static void main(String[] args) {
        int n = 11;
        int dp[] = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println(minSquaresRC(n));
        System.out.println(minSquaresDp(n, dp));
        System.out.println(minSquaresIterative(n));
    }
}
