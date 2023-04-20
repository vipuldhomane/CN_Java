
import java.util.Scanner;
import java.lang.Math;

public class BinarytoDecimal {

    public static void main(String[] args) {
        // Write your code here
        Scanner s = new Scanner(System.in);
        long n = s.nextLong();
        long i = 1;
        long bin = 0;
        long temp = n;
        while (temp > 0) {
            long ld = temp % 2;
            bin = bin + i * ld;
            temp /= 2;
            i *= 10;
        }
        System.out.print(bin);

    }
}
