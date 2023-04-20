package Patterns1;
/*
 * 
1
23
456
78910
 */

import java.util.*;

public class tri_num2_pat {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int i = 1;
        // here we are using 3rd variable p to print values.
        int p = 1;
        while (i <= n) {
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
