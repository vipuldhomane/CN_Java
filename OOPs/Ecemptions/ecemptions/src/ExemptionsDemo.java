public class ExemptionsDemo {
    public static int fact(int n) throws NegetiveNumExeption {
        if (n < 0) {
            throw new NegetiveNumExeption();
        }
        int ans = 1;
        for (int i = 2; i <= n; i++) {
            ans *= i;
        }
        return ans;
    }

    public static int divide(int a, int b) throws ZeroDivisionErrorExemption {
        if (b == 0) {
            // throw new ArithmeticException();
            throw new ZeroDivisionErrorExemption();
        }
        return a / b;
    }

    public static void main(String[] args) {
        // System.out.println(4 / 0);
        // int a;
        try {
            divide(5, 0);
            fact(-1);
        } catch (ZeroDivisionErrorExemption e) {
            // TODO Auto-generated catch block
            System.out.println("Divide by Zero Exception raised");
            // e.printStackTrace();
        } catch (NegetiveNumExeption e) {
            // TODO Auto-generated catch block
            System.out.println("Error Caused due to negetive number");
        } finally {
            System.out.println("finally");
        }
        System.out.println("main");
    }
}
