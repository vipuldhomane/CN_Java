package Arrays.Arrays2D;

import java.util.*;

public class Array2dFuns {
    public static int[][] takeInput2d(int row, int colm) {
        Scanner sc = new Scanner(System.in);
        // System.out.println("Enter Number of Rows");
        // int row = sc.nextInt();
        // System.out.println("Enter Number of Columns");
        // int colm = sc.nextInt();

        // Syntax To Declare 2D array
        int array2d[][] = new int[row][colm];

        // taking input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm; j++) {
                System.out.println("Enter value for " + "(" + i + "," + j + ")" + "Position");
                array2d[i][j] = sc.nextInt();
            }
        }
        sc.close();
        return array2d;
    }

    public static void print2dArray(int arr[][]) {
        int row = arr.length;
        int colm = arr[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int array[][] = takeInput2d(3, 3);
        print2dArray(array);
    }
}
