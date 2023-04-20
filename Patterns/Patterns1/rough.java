package Patterns1;

import java.util.*;

public class rough {
    public static void main(String[] args) {
        /*
         * Your class should be named Solution.
         * Read input as specified in the question.
         * Print output as specified in the question.
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 0;
        while (i < n) {
            int spaces = 0;
            while (spaces < n - i - 1) {
                System.out.print(" ");
                spaces++;
            }
            int num = 0;
            while (num < i + 1) {
                System.out.print(num + 1 + i);
                num++;

            }
            int num2 = 0;
            while (num2 < i) {
                System.out.print(2 * i - num2);
                num2++;
            }
            System.out.println();
            i++;
        }
    }
}
