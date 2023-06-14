package Module3.Graphs;

import java.util.Scanner;

public class PrimsAlgorithm {
    public static void primsAlgorithm(int[][] adjMat) {
        int n = adjMat.length;
        // initialize the 3 arrays
        boolean visited[] = new boolean[n];
        int parent[] = new int[n];
        int weight[] = new int[n];
        // set the source
        parent[0] = -1;
        weight[0] = 0;
        // neglecting the source set the weight to max value
        // default value for parent is 0
        for (int i = 1; i < n; i++) {
            weight[i] = Integer.MAX_VALUE;
        }

        // traverse on mat
        for (int i = 0; i < n; i++) {
            int minVertex = findMinVertex(visited, weight);
            visited[minVertex] = true;
            for (int j = 0; j < n; j++) {
                if (adjMat[minVertex][j] != 0 && !visited[j]) {
                    // check if the latest weight is greater than original weight
                    // if yes then update the weight to original and parent to the minvertex

                    if (!visited[j] && weight[j] > adjMat[minVertex][j]) {
                        // update the values
                        weight[j] = adjMat[minVertex][j];
                        parent[j] = minVertex;
                    }
                }
            }
        }
        // Print the final answer
        // start from the index 1 as source was set to 0
        for (int i = 1; i < n; i++) {
            if (i < parent[i]) {
                System.out.println(i + " " + parent[i] + " " + weight[i]);
            } else {
                System.out.println(parent[i] + " " + i + " " + weight[i]);
            }
        }
    }

    private static int findMinVertex(boolean[] visited, int[] weight) {
        int minVertex = -1;
        // loop on visited array
        for (int i = 0; i < visited.length; i++) {
            // if || or condition is not used then loop wont run
            // check if the weight at i < weight at minVertex
            // if yes then update the minvertex to the i
            if (!visited[i] && (minVertex == -1 || weight[i] < weight[minVertex])) {
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
        primsAlgorithm(adjMat);
    }
}
