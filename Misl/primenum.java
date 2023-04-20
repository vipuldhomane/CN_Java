import java.util.Scanner;

public class primenum {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        // boolean isPrime = true;
        // if (n == 2) {
        // isPrime = true;
        // }
        for (int i = 2; i <= (n - 1); i++) {
            if (n % i == 0) {
                System.out.println("Composite");
                // isPrime = false;
                return;
                // Use of return keyword made this loop break once the condition achieves.
                // this means that time required to execute this program is reduced.
                // for an example 1000 is divisible by 2 so In first stage of loop once 2
                // divides 1000 loop will break with 1 loop
                // else if no division condition met the loop would have continued till end
                // and we would have reached to the conclusion that number is prime because no
                // division happened.
            }

        }
        System.out.println("Prime");
        // if (isPrime == true) {
        // System.out.println("prime");
        // } else {
        // System.out.println("composite");
        // }
    }
}
