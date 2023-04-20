import java.util.*;

public class asign7_5 {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        int num = sc.nextInt();

        int rem = 0;
        while (num != 0) {
            int bndigit = num % 2;
            rem = rem * 10 + bndigit;
            num /= 2;
        }
        // System.out.println(rem);
        int bn = 0;
        while (rem != 0) {
            int digit = rem % 10;
            bn = bn * 10 + digit;
            rem /= 10;
        }
        System.out.println(bn);
    }
}