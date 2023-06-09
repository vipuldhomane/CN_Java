package Module3.Graphs;

import java.util.*;

public class HasPath {
    public static boolean hasPath(int[][] adjMat, int s, int d, boolean visited[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(s);
        int n = adjMat.length;
        while (!q.isEmpty()) {
            int currentVertex = q.poll();
            visited[currentVertex] = true;
            if (currentVertex == d) {
                return true;
            }
            for (int i = 0; i < n; i++) {
                if (adjMat[currentVertex][i] == 1 && visited[i] == false) {
                    q.add(i);
                    visited[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int[][] adjMat = new int[n][n];
        for (int i = 0; i < e; i++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();

            adjMat[v1][v2] = 1;
            adjMat[v2][v1] = 1;
        }
        boolean visited[] = new boolean[adjMat.length];
        boolean HasPath = hasPath(adjMat, 1, 3, visited);
        System.out.println(HasPath);
    }
}
