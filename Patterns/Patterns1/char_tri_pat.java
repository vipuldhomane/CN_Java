package Patterns1;
// G

// FG
// EFG
// DEFG
// CDEFG
// BCDEFG
// ABCDEFG

import java.util.Scanner;

public class char_tri_pat {
    public static void main(String[] args) {
        // Your code goes here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 1;
        while (i <= n) {
            int j = 1;
            while (j <= i) {
                int p = (n - i + j);
                // Ascii values starts from 65 for A
                // tf.to not change the value well add to the p 65-1
                char q = (char) (p + 64);
                System.out.print(q);
                j++;

            }
            System.out.println();
            i++;
        }
    }
}