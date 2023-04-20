package Patterns1;

import java.util.*;

public class tri_num4_pat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 1;
        // here P is reinitiallised for each row
        // i.e. p=i; for each row
        while (i <= n) {
            int p = i;
            int j = 1;
            while (j <= i) {
                System.out.print(p);
                j++;
                p--;
            }
            i++;
            System.out.println();
        }
    }
}
