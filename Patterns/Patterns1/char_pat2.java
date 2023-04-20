package Patterns1;

import java.util.*;

public class char_pat2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while (i <= n) {
            int j = 1;
            // logic fot ith variable

            char p = (char) ('A' + i - 1);
            while (j <= n) {
                System.out.print(p + " ");
                j++;
                // here p cannote be directly incremented tf typecasting.
                p = (char) (p + 1);
            }
            i++;
            System.out.println();
        }
    }
}