package Patterns2;

import java.util.*;

/**
 * rough5
 */
public class Star_numpat {

    public static void main(String[] args) {

        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // int n = 5;
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                if (j >  ) {
                    System.out.print("*");
                } else {
                    System.out.print(j);
                }

            }
            for (int j = n; j >= 1; j--) {
                if (j > n - i + 1) {
                    System.out.print("*");
                } else {
                    System.out.print(j);
                }
            }
            System.out.println();

        }

    }
}
