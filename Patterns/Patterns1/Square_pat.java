package Patterns1;

import java.util.Scanner;

public class Square_pat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        /* Using While loops */
        // Syntax of For loops is easy to understand
        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= n) {
                System.out.print("* ");
                j++;
            }
            i++;
            System.out.println();
        }
    }
}
