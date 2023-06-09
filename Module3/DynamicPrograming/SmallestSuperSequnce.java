package Module3.DynamicPrograming;

public class SmallestSuperSequnce {
    public static int smallestSuperSequenceRC(String str1, String str2) {

        if (str1.isEmpty()) {
            return str2.length();

        }
        if (str2.isEmpty()) {
            return str1.length();
        }
        // if (str1.length() == 0 || str2.length() == 0) {
        // return 0;
        // }
        if (str1.charAt(0) == str2.charAt(0)) {
            return 1 + smallestSuperSequenceRC(str1.substring(1), str2.substring(1));

        } else {
            int ans1 = smallestSuperSequenceRC(str1.substring(1), str2);
            int ans2 = smallestSuperSequenceRC(str1, str2.substring(1));
            return 1 + Math.min(ans1, ans2);
        }
    }

    public static int smallestSuperSequence(String str1, String str2) {
        int len1 = str1.length();
        int len2 = str2.length();
        int superseq[][] = new int[len1 + 1][len2 + 1];
        for (int p = 0; p <= len1; p++) {
            for (int q = 0; q <= len2; q++) {
                if (p == 0) {
                    superseq[p][q] = q;
                } else if (q == 0) {
                    superseq[p][q] = p;
                } else if (str1.charAt(p - 1) == str2.charAt(q - 1)) {
                    superseq[p][q] = 1 + superseq[p - 1][q - 1];
                } else {
                    superseq[p][q] = 1 + Math.min(superseq[p - 1][q], superseq[p][q - 1]);
                }
            }
        }
        return superseq[len1][len2];
    }

    public static int smallestSuperSequenceMV(String str1, String str2) {
        int m = str1.length();
        int n = str2.length();
        int dp[][] = new int[m + 1][n + 1];
        // run the loop
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {

                // Case if one of the string is empty
                if (i == 0) {
                    dp[i][j] = j;
                } else if (j == 0) {
                    dp[i][j] = i;
                } else if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = 1 + Math.min(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];

    }

    public static void main(String[] args) {
        String str1 = "abc";
        String str2 = "fac";
        System.out.println(smallestSuperSequenceRC(str1, str2));
        System.out.println(smallestSuperSequence(str1, str2));
        System.out.println(smallestSuperSequenceMV(str1, str2));
    }
}
