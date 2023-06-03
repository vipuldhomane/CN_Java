package Module3.DynamicPrograming;

public class MaxLoot {
    // Cn Solution

    public static int maxMoneyLooted(int[] houses) {
        int n = houses.length;

        // Special case
        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return houses[0];
        }

        int[] maxMoneyCanBeLooted = new int[n];

        maxMoneyCanBeLooted[0] = houses[0];
        maxMoneyCanBeLooted[1] = Math.max(houses[0], houses[1]);

        for (int i = 2; i < n; i++) {
            maxMoneyCanBeLooted[i] = Math.max(maxMoneyCanBeLooted[i - 1],
                    (houses[i] + maxMoneyCanBeLooted[i - 2]));
        }

        return maxMoneyCanBeLooted[n - 1];
    }

    // Recursive
    public static int maxLoot(int[] arr, int n) {
        if (n == 0) {
            return 0;
        }
        if (n == 1) {
            return arr[0];
        }
        if (n == 2) {
            return Math.max(arr[0], arr[1]);
        }
        return Math.max(maxLoot(arr, n - 1), maxLoot(arr, n - 2) + arr[n - 1]);
    }

}
