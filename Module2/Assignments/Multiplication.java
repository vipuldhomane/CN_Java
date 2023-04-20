package Module2.Assignments;

public class Multiplication {
    public static int multiplyTwoIntegers(int m, int n) {
        if (n == 0 || m == 0) {
            return 0;
        }
        int smallMult = multiplyTwoIntegers(m, n - 1);
        return m + smallMult;

    }

    public static void main(String[] args) {
        System.out.println(multiplyTwoIntegers(0, 10));
    }
}
