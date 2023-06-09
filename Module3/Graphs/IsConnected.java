package Module3.Graphs;

import java.util.*;

public class IsConnected {
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
        if (n == 0 || e == 0) {
            System.out.println("false");
            return;
        }
        boolean ans = isConnected(adjMat);
        System.out.println(ans);
    }

    public static boolean isConnected(int[][] adjMat) {
        boolean[] visited = new boolean[adjMat.length];
        DFS(adjMat, 0, visited);
        for (boolean element : visited) {
            if (element == false) {
                return false;
            }
        }
        return true;
    }

    private static void DFS(int[][] adjMat, int currentVertex, boolean[] visited) {
        visited[currentVertex] = true;

        for (int i = 0; i < adjMat.length; i++) {
            if (adjMat[currentVertex][i] == 1 && visited[i] == false) {
                DFS(adjMat, i, visited);
            }
        }
        return;
    }
}
