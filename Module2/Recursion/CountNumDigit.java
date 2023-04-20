package Module2.Recursion;

public class CountNumDigit {
    public static int count(int n) {
        int count = 0;
        if (n == 0) {
            return 0;
        }
        int smallOutput = count(n / 10);
        count = 1 + smallOutput;
        return count;
    }

    public static void main(String[] args) {
        int num = 0;
        System.out.println(count(num));
    }
}
