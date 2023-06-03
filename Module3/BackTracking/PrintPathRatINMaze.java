package Module3.BackTracking;

public class PrintPathRatINMaze {
    public static void PrintRatInAMaze(int maze[][]) {
        int n = maze.length;
        int path[][] = new int[n][n];
        printPath(maze, 0, 0, path);

    }

    private static void printPath(int[][] maze, int i, int j, int[][] path) {
        // Base Case
        int n = maze.length;
        if (i < 0 || i >= n || j < 0 || j >= n || maze[i][j] == 0 || path[i][j] == 1) {
            return;
        }
        // update the path
        path[i][j] = 1;
        // check if we have reached destination
        if (i == n - 1 && j == n - 1) {
            for (int a = 0; a < n; a++) {
                for (int b = 0; b < n; b++) {
                    System.out.print(path[a][b] + " ");
                }
                // System.out.println();
            }

            System.out.println();
            path[i][j] = 0;
            return;
        }
        // we are present here means this condition is not met
        // not try on the directions
        // top
        printPath(maze, i - 1, j, path);
        // right
        printPath(maze, i, j + 1, path);
        // down
        printPath(maze, i + 1, j, path);
        // left
        printPath(maze, i, j - 1, path);
        path[i][j] = 0;
        return;
    }

    // CN solution
    static void printsolution(int[][] solution) {
        // for (int i = 0; i < n; i++) {
        // for (int j = 0; j < n; j++) {
        // System.out.print(solution[i][j] + " ");
        // }
        // }
        for (int[] rows : solution) {
            for (int element : rows) {
                System.out.print(element + " ");
            }
            System.out.println(); // comment this for ans in single line
        }
    }

    static void solveMaze(int maze[][], int solution[][], int x, int y, int n) {

        if (x == n - 1 && y == n - 1) {
            solution[x][y] = 1;
            printsolution(solution);
            System.out.println();
            return;
        }
        // if (x > n - 1 || x < 0 || y > n - 1 || y < 0) {
        // return;
        // }
        if (x > n - 1 || x < 0 || y > n - 1 || y < 0 || maze[x][y] == 0 || solution[x][y] == 1) {
            return;
        }

        solution[x][y] = 1;
        solveMaze(maze, solution, x - 1, y, n);
        solveMaze(maze, solution, x + 1, y, n);
        solveMaze(maze, solution, x, y - 1, n);
        solveMaze(maze, solution, x, y + 1, n);
        solution[x][y] = 0;
    }

    static void ratInAMaze(int maze[][], int n) {
        int[][] solution = new int[n][n];
        solveMaze(maze, solution, 0, 0, n);
    }

    public static void main(String[] args) {
        int[][] maze = { { 1, 0, 1 }, { 1, 0, 1 }, { 1, 1, 1 } };
        ratInAMaze(maze, 3);
    }
}
