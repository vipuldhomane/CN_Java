package Module2.Recursion;

public class PrintNaturalNum {
    public static void print(int n) {
        // base condition
        if (n == 0) {
            return;
        }
        print(n - 1);
        System.out.println(n);
    }

    public static void main(String[] args) {
        print(10);
    }
}
