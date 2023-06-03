package Module3.DynamicPrograming;

import java.util.Arrays;

public class LogestCommonSubseq {
    public static int lcsRC(String str1, String str2, int i, int j) {
        // Recursive
        // base case
        // when one of the string ends there wont be any subsequences
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }
        int myAns;
        if (str1.charAt(i) == str2.charAt(j)) {
            int smallAns = lcsRC(str1, str2, i + 1, j + 1);
            myAns = 1 + smallAns;
        } else {
            int ans1 = lcsRC(str1, str2, i + 1, j);
            int ans2 = lcsRC(str1, str2, i, j + 1);
            myAns = Math.max(ans1, ans2);
        }
        return myAns;

    }

    public static int lcsMemo(String str1, String str2, int i, int j, int[][] dp) {
        // Recursive
        // base case
        // when one of the string ends there wont be any subsequences
        if (i >= str1.length() || j >= str2.length()) {
            return 0;
        }
        int myAns;
        if (str1.charAt(i) == str2.charAt(j)) {
            int smallAns;
            if (dp[i + 1][j + 1] == -1) {
                smallAns = lcsMemo(str1, str2, i + 1, j + 1, dp);
                dp[i + 1][j + 1] = smallAns;

            } else {
                smallAns = dp[i + 1][j + 1];
            }
            myAns = 1 + smallAns;
        } else {
            int ans1, ans2;
            if (dp[i + 1][j] == -1) {
                ans1 = lcsMemo(str1, str2, i + 1, j, dp);
                dp[i + 1][j] = ans1;
            } else {
                ans1 = dp[i + 1][j];
            }
            if (dp[i][j + 1] == -1) {
                ans2 = lcsMemo(str1, str2, i, j + 1, dp);
                dp[i][j + 1] = ans2;
            } else {
                ans2 = dp[i][j + 1];
            }
            myAns = Math.max(ans1, ans2);

        }
        return myAns;

    }

    public static int lcs(String str1, String str2) {
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] rows : dp) {
            Arrays.fill(rows, 0);
        }
        for (int i = str1.length() - 1; i >= 0; i--) {
            for (int j = str2.length() - 1; j >= 0; j--) {
                if (str1.charAt(i) == str2.charAt(j)) {
                    dp[i][j] = 1 + dp[i + 1][j + 1];
                } else {
                    dp[i][j] = Math.max(dp[i + 1][j], dp[i][j + 1]);
                }
            }
        }
        return dp[0][0];

    }

    public static void main(String[] args) {
        String str1 = "bedgmc";
        String str2 = "abdfglc";
        int dp[][] = new int[str1.length() + 1][str2.length() + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println(lcsMemo(str1, str2, 0, 0, dp));
        System.out.println(lcs(str1, str2));
    }
}
