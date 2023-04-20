import java.util.Scanner;

public class powerof_num {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double x = sc.nextInt();
        double n = sc.nextInt();
        // finding the X^n

        int power = (int) (Math.pow(x, n));
        System.out.println(power);

    }
}
