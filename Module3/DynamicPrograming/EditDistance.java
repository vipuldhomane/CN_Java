package Module3.DynamicPrograming;

import java.util.Arrays;

// You are given two strings S and T of lengths M and N, respectively. Find the 'Edit Distance' between the strings.
// Edit Distance of two strings is the minimum number of steps required to make one string equal to the other. In order to do so, you can perform the following three operations:
// 1. Delete a character
// 2. Replace a character with another one
// 3. Insert a character
public class EditDistance {
    public static int editDistanceRC(String s, String t) {
        // Your code goes here
        int m = s.length();
        int n = t.length();
        // base case
        // if one of the string ends and other one is remaining then there is only
        // option to add whatever left in other string
        if (m == 0) {
            return n;
        }
        if (n == 0) {
            return m;
        }
        if (s.charAt(0) == t.charAt(0)) {
            return editDistanceRC(s.substring(1), t.substring(1));
        } else {
            int ans1 = editDistanceRC(s.substring(1), t);
            int ans2 = editDistanceRC(s, t.substring(1));
            int ans3 = editDistanceRC(s.substring(1), t.substring(1));
            return 1 + Math.min(ans1, Math.min(ans2, ans3));
        }
    }

    // public static int editDistance(String s, String t, int i, int j, int[][] dp)
    // {
    // // Your code goes here
    // int m = s.length();
    // int n = t.length();
    // // base case
    // // if one of the string ends and other one is remaining then there is only
    // // option to add whatever left in other string
    // if (m == 0) {
    // return n;
    // }
    // if (n == 0) {
    // return m;
    // }
    // if (dp[m][n] != -1) {
    // return dp[m][n];
    // }

    // }

    // cn
    private static int editDistanceHelper(String s, String t, int[][] subProblems) {

        if (s.length() == 0) {
            return t.length();
        }

        if (t.length() == 0) {
            return s.length();
        }

        int m = s.length();
        int n = t.length();

        if (subProblems[m][n] != -1) {
            return subProblems[m][n];
        }

        if (s.charAt(0) == t.charAt(0)) {
            int smallAns = editDistanceHelper(s.substring(1), t.substring(1), subProblems);
            subProblems[m - 1][n - 1] = smallAns;
            subProblems[m][n] = 0 + smallAns;
        } else {
            int remove = editDistanceHelper(s.substring(1), t, subProblems);
            subProblems[m - 1][n] = remove;

            int insert = editDistanceHelper(s, t.substring(1), subProblems);
            subProblems[m][n - 1] = insert;

            int substitute = editDistanceHelper(s.substring(1), t.substring(1), subProblems);
            subProblems[m - 1][n - 1] = substitute;

            subProblems[m][n] = 1 + Math.min(remove, Math.min(insert, substitute));
        }

        return subProblems[m][n];

    }

    public static int editDistance(String s, String t) {

        int m = s.length();
        int n = t.length();

        int[][] subProblems = new int[(m + 1)][(n + 1)];

        // Assigning all the values with -1
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                subProblems[i][j] = -1;
            }
        }

        return editDistanceHelper(s, t, subProblems);
    }

    public static void main(String[] args) {
        String str1 = "whgtdwhgtdg";
        String str2 = "aswcfg";
        int[][] dp = new int[str1.length() + 1][str2.length() + 1];
        for (int[] row : dp) {
            Arrays.fill(row, -1);
        }
        // System.out.println(editDistance(str1, str2, 0, 0, dp));
    }
}
