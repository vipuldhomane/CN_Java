package Functions;

import java.util.Scanner;

public class primenum {
    public static boolean isPrime(int num) {
        int i = 2;
        // boolean isprime = false;
        while (i <= num / 2) {
            if (num % i == 0) {
                return false;
            }
            i++;
        }
        return true;
    }

    public static boolean isPrime2(int num) {
        boolean isPrime = true;
        for (int i = 2; i <= num / 2; i++) {
            if (num % i == 0) {
                isPrime = false;
                break;
            }
        }
        return isPrime;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        // System.out.println(isPrime(n));
        System.out.println(isPrime2(n));
        sc.close();
    }
}
