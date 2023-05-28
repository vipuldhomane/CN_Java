package Module3.Recursion3;

//top down approach

public class Factorial {
    public static void printFactorial(int n, int answer) {
        if (n == 0) {
            System.out.println(answer);
            return;
        }
        answer = n * answer;
        printFactorial(n - 1, answer);
    }

    public static void main(String[] args) {
        printFactorial(5, 1);
    }

}
