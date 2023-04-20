package Patterns1;

import java.util.Scanner;

public class roogh {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1, p = n; j <= i; j++, p--) {
                System.out.print((char) (p + 64));
            }
            // p++;
            System.out.println();
        }
    }
}
