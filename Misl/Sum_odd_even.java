import java.util.Scanner;

public class Sum_odd_even {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sum_even = 0;
        int sum_odd = 0;
        int i = 0;
        while (n > 0) {
            i = n % 10;
            n = n / 10;
            // System.out.println(i);
            // System.out.println(n);
            if (i % 2 == 0) {
                sum_even += i;
            } else {
                sum_odd += i;
            }
        }
        System.out.println(sum_even + " " + sum_odd);
    }
}
