package Module2.Test6;

import java.util.Scanner;

public class RottenOranges {

    // Check if i, j is under the array
    // limits of row and column
    static boolean issafe(int i, int j, int R, int C) {
        return i >= 0 && i < R &&
                j >= 0 && j < C;
    }

    static int rotOranges(int v[][]) {
        boolean changed = false;
        int no = 2;
        int R = v.length, C = v[0].length;

        while (true) {
            for (int i = 0; i < R; i++) {
                for (int j = 0; j < C; j++) {

                    // Rot all other oranges present at

                    if (v[i][j] == no) {
                        if (issafe(i + 1, j, R, C) &&
                                v[i + 1][j] == 1) {
                            v[i + 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j + 1, R, C) &&
                                v[i][j + 1] == 1) {
                            v[i][j + 1] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i - 1, j, R, C) &&
                                v[i - 1][j] == 1) {
                            v[i - 1][j] = v[i][j] + 1;
                            changed = true;
                        }
                        if (issafe(i, j - 1, R, C) &&
                                v[i][j - 1] == 1) {
                            v[i][j - 1] = v[i][j] + 1;
                            changed = true;
                        }
                    }
                }
            }
            // If no rotten orange found it means all
            // oranges rottened now
            if (!changed)
                break;

            changed = false;
            no++;
        }
        for (int i = 0; i < R; i++) {
            for (int j = 0; j < C; j++) {
                // If any orange is found to be
                // not rotten then ans is not possible
                if (v[i][j] == 1)
                    return -1;
            }
        }
        // Because initial value for a rotten
        // orange was 2
        return no - 2;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt(), m = scanner.nextInt();
        int[][] arr = new int[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                arr[i][j] = scanner.nextInt();
            }
        }
        System.out.println(rotOranges(arr));
    }
}
