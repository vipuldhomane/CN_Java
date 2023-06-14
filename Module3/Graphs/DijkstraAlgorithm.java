package Module3.Graphs;

import java.util.Scanner;

/**
 * DijkstraAlgoritum
 */
public class DijkstraAlgorithm {

    private static void dijkstraAlgorithm(int[][] adjMat) {
        int n = adjMat.length;
        boolean visited[] = new boolean[n];
        int distance[] = new int[n];
        distance[0] = 0;
        for (int i = 1; i < n; i++) {
            distance[i] = Integer.MAX_VALUE;
        }
        // loop till n-1
        for (int i = 0; i < n - 1; i++) {
            // find the minVertex with lowest distance and unvisited
            int minVertex = findMinVertex(visited, distance);
            visited[minVertex] = true;
            // loop over the neighbors of minvertex
            for (int j = 0; j < n; j++) {
                if (adjMat[minVertex][j] > 0 && !visited[j] && adjMat[minVertex][j] < Integer.MAX_VALUE) {
                    // this is unvisited neighbors
                    // find the new distance
                    int newDist = distance[minVertex] + adjMat[minVertex][j];
                    // check if new distance is better than previous
                    if (newDist < distance[j]) {
                        //
                        distance[j] = newDist;
                    }
                }
            }
        }
        for (int i = 0; i < n; i++) {
            System.out.println(i + " " + distance[i]);
        }
    }

    private static int findMinVertex(boolean[] visited, int[] distance) {
        // choose the vertex which distance is lesser than rest
        int minVertex = -1;

        for (int i = 0; i < visited.length; i++) {
            // update the minvertex to the latest lowest distance
            if (!visited[i] && (minVertex == -1 || distance[i] < distance[minVertex])) {
                minVertex = i;
            }
        }
        return minVertex;
    }

    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        int n = s.nextInt();
        int e = s.nextInt();
        int adjMat[][] = new int[n][n];
        for (int j = 0; j < e; j++) {
            int v1 = s.nextInt();
            int v2 = s.nextInt();
            int weight = s.nextInt();
            adjMat[v1][v2] = weight;
            adjMat[v2][v1] = weight;
        }
        dijkstraAlgorithm(adjMat);
    }

}
