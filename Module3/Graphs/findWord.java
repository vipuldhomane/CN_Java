package Module3.Graphs;
/*
2 11
CXDXNXNXNXA
XOXIXGXIXJX
 */

public class findWord {
    int[][] a = { { -1, -1 }, { -1, 0 }, { -1, 1 }, { 0, -1 }, { 0, 1 }, { 1, -1 }, { 1, 0 }, { 1, 1 } };
    String pattern = "CODINGNINJA";
    int[][] visited;

    int validPoint(int x, int y, int N, int M) {
        // Check if the movement is in the range
        if (x >= 0 && x < N && y >= 0 && y < M)
            return 1;
        return 0;
    }

    int DFS(String[] Grid, int x, int y, int index, int N, int M) {
        // if we reached at the last index of the string then it means we have found the
        // way
        // hence return true or 1
        if (index == 11)
            return 1;
        // This is a proper backtracking approach mark visited as 1 and if ans is not
        // met then un-mark.
        visited[x][y] = 1;
        int i, newX, newY;
        int found = 0;
        // Traverse for each possible direction on x, y axis

        for (i = 0; i < 8; i++) {

            newX = x + a[i][0];
            newY = y + a[i][1];
            // String pattern = "CODINGNINJA";
            if (validPoint(newX, newY, N, M) == 1 && Grid[newX].charAt(newY) == pattern.charAt(index)
                    && visited[newX][newY] == 0) {
                // this is using bitwise operator it will update the found value if 1 is
                // returned.
                int ans = DFS(Grid, newX, newY, index + 1, N, M);

                if (ans == 1) {
                    found = 1;
                }

                // found = found | DFS(Grid, newX, newY, index + 1, N, M);
            }
        }
        // backtracking if the above condition is not met

        visited[x][y] = 0;

        return found;
    }

    public int solve(String[] Graph, int N, int M) {
        int i, j, found = 0;

        visited = new int[N][M];

        for (i = 0; i < N; i++) {
            for (j = 0, found = 0; j < M; j++) {
                if (Graph[i].charAt(j) == 'C') {
                    found = DFS(Graph, i, j, 1, N, M);
                    if (found == 1)
                        break;
                }
            }
            if (found == 1)
                break;
        }

        return found;

    }

    public static void main(String[] args) {
        int []  []   Graph = {{}};
        int ans = solve
    }
}
