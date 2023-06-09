package Module3.Graphs;

import java.util.*;

public class getpathBFS {
    public static ArrayList<Integer> getPathBFS(int[][] adjMat, int s, int e) {
        Queue<Integer> pendingVertices = new LinkedList<>();
        boolean visited[] = new boolean[adjMat.length];
        HashMap<Integer, Integer> map = new HashMap<>();

        visited[s] = true;
        pendingVertices.add(s);
        map.put(s, -1);

        boolean pathFound = false;

        while (!pendingVertices.isEmpty()) {
            int currentVertex = pendingVertices.poll();
            System.out.print(currentVertex + " ");
            for (int i = 0; i < adjMat.length; i++) {
                if (adjMat[currentVertex][i] == 1 && visited[i] == false) {
                    pendingVertices.add(i);
                    visited[i] = true;
                    map.put(i, currentVertex);
                    if (i == e) {
                        pathFound = true;
                        break;
                    }
                }
            }

        }
        if (pathFound == true) {
            ArrayList<Integer> path = new ArrayList<>();
            int currentVertex = e;
            while (currentVertex != -1) {
                path.add(currentVertex);
                int parent = map.get(currentVertex);
                currentVertex = parent;
            }
            return path;
        } else {
            return null;
        }
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
        int source = s.nextInt();
        int end = s.nextInt();
        ArrayList<Integer> path = getPathBFS(adjMat, source, end);
        System.out.println(path);
    }
}
