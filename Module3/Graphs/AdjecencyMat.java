package Module3.Graphs;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class AdjecencyMat {
    public static void bftraversal(int[][] adjMat) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMat.length];
        visited[0] = true;
        pendingVertices.add(0);

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < adjMat.length; i++) {
                if (adjMat[currentVertex][i] == 1 && visited[i] == false) {
                    pendingVertices.add(i);
                    visited[i] = true;
                }
            }
        }
    }

    public static void dfTraversal(int[][] adjMat, int currentVertex, boolean visited[]) {
        visited[currentVertex] = true;
        System.out.print(currentVertex + " ");
        // loop over ith row
        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[currentVertex][i] == 1 && visited[i] == false) {
                dfTraversal(adjMat, i, visited);
            }
        }
    }

    public static void dfTraversal(int[][] adjMat) {
        boolean visited[] = new boolean[adjMat.length];
        for (int i = 0; i < adjMat.length; i++) {
            if (!visited[i]) {
                dfTraversal(adjMat, i, visited);
                System.out.println();
            }
        }
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
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(adjMat[i][j] + " ");

        // }
        // System.out.println();
        // }
        for (int[] row : adjMat) {
            for (int x : row) {
                System.out.print(x + " ");
            }
            System.out.println();
        }
        dfTraversal(adjMat);
        // int[][] mat = { { 0, 1, 0, 1 },
        // { 1, 0, 1, 0 },
        // { 0, 1, 0, 0 },
        // { 1, 0, 0, 0 } };
        // dfTraversal(mat);
        // System.out.println();
        // bftraversal(mat);
    }
}
