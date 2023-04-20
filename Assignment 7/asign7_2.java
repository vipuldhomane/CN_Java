// Terms of AP
// Send Feedback
// Write a program to print first x terms of the series 3N + 2 which are not multiples of 4.

import java.util.*;

public class asign7_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int x = sc.nextInt();
        int count = 1;
        int n = 1;
        while (count <= x) {
            int term = 3 * n + 2;
            n++;
            if (term % 4 == 0) {
                count--;
            } else {
                System.out.print(term + " ");
            }
            count++;
        }
    }
}
