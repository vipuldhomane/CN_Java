package Module3.Test7;

import java.util.Arrays;
import java.util.Scanner;

public class MaxDistancebetnSameChar {
    public static int maxDist(String str) {
        int maxDistance = -1;
        int dp[] = new int[26];
        Arrays.fill(dp, -1);

        for (int i = 0; i < str.length(); i++) {
            int index = str.charAt(i) - 'a';
            if (dp[index] != -1) {
                int distance = i - dp[index] - 1;
                maxDistance = Math.max(maxDistance, distance);
            }
            dp[index] = i;
        }
        return maxDistance;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        for (int i = 0; i < n; i++) {
            String str = s.nextLine();
            System.out.println(maxDist(str));
        }
    }
}
