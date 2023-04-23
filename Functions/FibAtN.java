package Functions;

// import java.rmi.server.RemoteStub;

public class FibAtN {
    public static int fibAtN(int n) {
        if (n == 0)
            return 0;
        int a = 0;
        int b = 1;
        int c = 0;

        for (int i = 0; i < n; i++) {
            c = a + b;
            a = b;
            b = c;

        }
        return a;
    }

    public static void main(String[] args) {
        for (int i = 1; i <= 10; i++) {
            System.out.println(i + " " + fibAtN(i));

        }
    }
}
