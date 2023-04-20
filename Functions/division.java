package Functions;

public class division {
    public static double division(double a, double b) {
        if (b == 0) {
            System.out.println("zerodiveror");
            return Integer.MIN_VALUE;
        } else {
            double div = a / b;
            return div;
        }
    }

    public static void divide(double a, double b) {
        if (b == 0) {
            System.out.println("Cannot divide by zero");
            return;
        } else {
            System.out.println(a / b);
        }

    }

    public static void main(String[] args) {
        double a = 100, b = 0;
        double div = division(a, b);
        System.out.println(div);
        divide(10.0, 210.0);

    }
}
