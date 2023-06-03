package Module3.BackTracking;

public class RatInAMaze {
    public static boolean ratInAMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        return solveMaze(maze, 0, 0, path);

    }

    private static boolean solveMaze(int[][] maze, int i, int j, int[][] path) {
        // Base Case
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return false;
        }
        // update the path
        // check if we have reached destination
        path[i][j] = 1;
        if (i == n - 1 && j == n - 1) {
            return true;
        }
        // we are present here means this condition is not met
        // not try on the directions
        // top
        if (solveMaze(maze, i - 1, j, path)) {
            return true;
        }
        // right
        if (solveMaze(maze, i, j + 1, path)) {
            return true;
        }
        // down
        if (solveMaze(maze, i + 1, j, path)) {
            return true;
        }
        // left
        if (solveMaze(maze, i, j - 1, path)) {
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 1, 0 }, { 1, 1, 0 }, { 1, 1, 1 } };
        boolean path = ratInAMaze(maze);
        System.out.println(path);
    }
}
