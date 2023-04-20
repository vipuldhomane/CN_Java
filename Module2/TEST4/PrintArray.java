package Module2.TEST4;

/**
 * PrintArray
 */
public class PrintArray {

    public static void print2darray(int input[][]) {
        // write your code here
        int n = input.length; // number of rows
        int m = input[0].length; // number of columns
        for (int i = 0; i < n; i++) {
            // print the current row n - i times
            // can also use j= i to j<n this will also works fine
            for (int j = 0; j < n - i; j++) {
                // print each element of the current row
                for (int k = 0; k < m; k++) {
                    System.out.print(input[i][k] + " ");
                }
                System.out.println();
            }
        }

    }
}
