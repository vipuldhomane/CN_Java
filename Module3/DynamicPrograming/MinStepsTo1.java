package Module3.DynamicPrograming;

public class MinStepsTo1 {

    // Dp solution
    // Most optimal
    public static int countMinStepsToOne(int n) {
        // initialise the empty dp array
        int dp[] = new int[n + 1];

        // base case
        dp[1] = 0;
        // so we have ans till 1 now run loop from 2 to n
        for (int i = 2; i <= n; i++) {
            // initialize the min steps
            int minSteps = dp[i - 1];

            // check if i is divisible by 2 and update the min steps accordingly
            if (i % 2 == 0) {
                minSteps = Math.min(minSteps, dp[i / 2]);
            }
            // similarly if i is divisible by 3 update the minSteps accordingly

            if (i % 3 == 0) {
                minSteps = Math.min(minSteps, dp[i / 3]);
            }

            // add one to the min steps to account current position
            dp[i] = minSteps + 1;

        }
        return dp[n];
    }

    public static int countMinStepsToOneRC(int n) {

        // Base case
        if (n == 1) {
            // There are zero steps to reduce 1 to 1
            return 0;
        }

        // Recursive case
        // Initialize the minimum steps to the result of subtracting 1 from n
        int minSteps = countMinStepsToOneRC(n - 1);

        // Check if n is divisible by 2 and update the minimum steps accordingly
        if (n % 2 == 0) {
            minSteps = Math.min(minSteps, countMinStepsToOneRC(n / 2));
        }

        // Check if n is divisible by 3 and update the minimum steps accordingly
        if (n % 3 == 0) {
            minSteps = Math.min(minSteps, countMinStepsToOneRC(n / 3));
        }

        // Add one to the minimum steps to account for the current step
        return minSteps + 1;
    }

    // This is the recursive solution with overlapping conditions
    public static int minStepsto1RC(int n) {
        // base case
        if (n == 1) {
            return 0;
        }
        int ans1 = minStepsto1RC(n - 1);
        int ans2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            ans2 = minStepsto1RC(n / 2);
        }
        int ans3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            ans3 = minStepsto1RC(n / 3);
        }
        int myAns = Math.min(ans1, Math.min(ans2, ans3));
        return myAns + 1;
    }

    public static int minStepsto1dp(int n, int[] dp) {
        // base case
        if (n == 1) {
            return 0;
        }
        int ans1;
        if (dp[n - 1] == -1) {
            ans1 = minStepsto1dp(n - 1, dp);
            dp[n - 1] = ans1;
        } else {
            ans1 = dp[n - 1];
        }
        int ans2 = Integer.MAX_VALUE;
        if (n % 2 == 0) {
            if (dp[n / 2] == -1) {
                ans2 = minStepsto1dp(n / 2, dp);
                dp[n / 2] = ans2;
            } else {
                ans2 = dp[n / 2];
            }
        }
        int ans3 = Integer.MAX_VALUE;
        if (n % 3 == 0) {
            if (dp[n / 3] == -1) {
                ans3 = minStepsto1dp(n / 3, dp);
                dp[n / 3] = ans3;
            } else {
                ans3 = dp[n / 3];

            }
        }
        int myAns = Math.min(ans1, Math.min(ans2, ans3));
        return myAns + 1;
    }

    public static void main(String[] args) {
        int n = 10;
        int[] dp = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }
        System.out.println(minStepsto1dp(n, dp));
        // System.out.println(minStepsto1RC(n));
        System.out.println(countMinStepsToOne(10));
    }
}
