package Patterns2;

import java.util.Scanner;

public class num_hill {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 1;
        while (i <= n) {
            int spaces = 1;
            while (spaces <= n - i) {
                System.out.print(" ");
                spaces++;

            }
            int num = 1;
            while (num <= i) {
                System.out.print(num);
                num = num + 1;
            }
            int dec = i - 1;
            while (dec >= 1) {
                System.out.print(dec);
                dec--;
            }
            System.out.println();
            i++;
        }
    }
}
