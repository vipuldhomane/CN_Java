package Module2.Recursion;

public class recursion {
    public static int fun(int a) {
        if (a == 0) {
            return 1;
        }
        int smallOutput = fun(a - 1);
        int output = a * smallOutput;
        return output;
    }

    public static int sumN(int a) {
        // base case
        if (a == 0) {
            return 0;
        }
        // assumption and induction
        int smallOutput = sumN(a - 1);
        int sum = a + smallOutput;
        return sum;

    }

    public static void main(String[] args) {
        System.out.println(fun(6));
        System.out.println(sumN(10));
    }
}
