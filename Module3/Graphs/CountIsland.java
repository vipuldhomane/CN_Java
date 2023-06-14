package Module3.Graphs;

import java.util.Scanner;

public class CountIsland {
    public static void dfTraversal(int[][] adjMat, int currentVertex, boolean visited[]) {
        visited[currentVertex] = true;
        // System.out.print(currentVertex + " ");
        // loop over ith row
        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[currentVertex][i] == 1 && visited[i] == false) {
                dfTraversal(adjMat, i, visited);
            }
        }
    }

    public static void countIsland(int[][] adjMat) {
        boolean visited[] = new boolean[adjMat.length];
        int count = 0;
        for (int i = 0; i < adjMat.length; i++) {
            if (!visited[i]) {
                dfTraversal(adjMat, i, visited);
                count++;
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMat[][] = new int[n][n];
        for (int j = 0; j < e; j++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            adjMat[v1][v2] = 1;
            adjMat[v2][v1] = 1;
        }

        countIsland(adjMat);
        s.close();
    }
}
