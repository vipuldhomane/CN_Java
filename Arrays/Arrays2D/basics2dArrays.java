package Arrays.Arrays2D;

import java.util.*;

public class basics2dArrays {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter Number of Rows");
        int row = sc.nextInt();
        System.out.println("Enter Number of Columns");
        int colm = sc.nextInt();

        // Syntax To Declare 2D array
        int array2d[][] = new int[row][colm];

        // taking input
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm; j++) {
                System.out.println("Enter value for " + "(" + i + "," + j + ")" + "Position");
                array2d[i][j] = sc.nextInt();
            }
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < colm; j++) {
                System.out.print(array2d[i][j] + " ");
            }
            System.out.println();
        }
    }
}
