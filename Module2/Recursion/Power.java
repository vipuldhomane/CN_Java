package Module2.Recursion;

public class Power {
    public static int power(int x, int n) {
        // x^n = x^(n-1)*x
        // base case x^0 = 1
        if (n == 0) {
            return 1;
        }
        int smallOutput = power(x, n - 1);
        int output = x * smallOutput;
        return output;
    }

    public static void main(String[] args) {
        System.out.println(power(10, 2));
    }
}
