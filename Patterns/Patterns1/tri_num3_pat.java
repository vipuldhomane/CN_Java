package Patterns1;
// 1

// 23
// 345
// 4567

import java.util.*;

public class tri_num3_pat {
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
                p++;
            }
            i++;
            System.out.println();
        }
    }
}
