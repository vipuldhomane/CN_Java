package Module2.Assignments;

public class SumofDigits {
    public static int sumOfDigits(int input) {
        if (input == 0) {
            return 0;
        }
        int smallOutput = sumOfDigits(input / 10);
        return input % 10 + smallOutput;
    }

    public static void main(String[] args) {
        int num = 12345;
        System.out.println(sumOfDigits(num));
    }
}
