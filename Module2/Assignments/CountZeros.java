package Module2.Assignments;

public class CountZeros {

    public static int countZeros(int input) {
        // base case: if input is zero, return 1
        if (input == 0) {
            return 1;
        }
        // base case: if input is negative or less than 10, return 0
        if (input < 0 || input < 10) {
            return 0;
        }
        // recursive case: divide input by 10 and check the remainder
        // if the remainder is zero, add 1 to the result
        // otherwise, add 0 to the result
        return countZeros(input / 10) + (input % 10 == 0 ? 1 : 0);
    }

    // CN solution

    public static int countZerosRec(int input) {
        if (input < 10) {
            if (input == 0)
                return 1;
            else
                return 0;
        }
        if (input % 10 == 0) {
            return countZerosRec(input / 10) + 1;
        } else
            return countZerosRec(input / 10);
    }

    public static void main(String[] args) {
        int num = 1;
        System.out.println(countZerosRec(num));
    }
}
