package Patterns1;
// A B C D 

// A B C D
// A B C D
// A B C D

import java.util.*;

public class Char_pat1_sq {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        for (int i = 1; i <= n; i++) {
            for (int j = 1, p = n; j <= n; j++, p--) {
                System.out.print((char) (p + 64));
            }
            System.out.println();
        }
    }
}
