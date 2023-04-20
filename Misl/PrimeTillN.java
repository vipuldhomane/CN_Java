import java.util.*;

public class PrimeTillN {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int i, number, count;

        for (number = 1; number <= n; number++) {
            count = 0;
            for (i = 2; i <= number / 2; i++) {
                if (number % i == 0) {
                    count++;
                    break;
                }
            }
            if (count == 0 && number != 1) {
                System.out.print(number + " ");
            }
        }
    }
}