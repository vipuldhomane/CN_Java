package RecusstionPractice;

import javax.management.modelmbean.XMLParseException;

public class Recursion {
    public static void PrintN(int n) {
        if (n == 0) {
            return;
        }
        System.out.print(n + " ");
        PrintN(n - 1);
        System.out.print(n + " ");

    }

    public static int Power(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int smallOutput = Power(x, n - 1);
        int output = x * smallOutput;
        return output;
    }

    public static int PowerOpt(int x, int n) {
        if (n == 0) {
            return 1;
        }
        int smallOutput = PowerOpt(x, n / 2);
        int xpn = 1;
        if (n % 2 == 0) {
            xpn = smallOutput * smallOutput;
        } else {
            xpn = smallOutput * smallOutput * x;
        }
        return xpn;

    }

    public static void main(String[] args) {
        // PrintN(5);
        System.out.println(Power(2, 10));
        System.out.println(PowerOpt(2, 10));
    }
}
