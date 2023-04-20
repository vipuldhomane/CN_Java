package Patterns2;

import java.util.*;
/*
4
432*
43*1
4*21
*321
 */

public class pat12 {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i = 1;
        while (i <= n) {
            int j = 1;
            int p = n;
            while (j <= n) {
                if (j == (n - i + 1)) {

                    System.out.print("*");
                    j++;
                    p--;
                } else {
                    System.out.print(p);
                    j++;
                    p--;
                }
            }
            System.out.println();
            i++;
        }

    }
}