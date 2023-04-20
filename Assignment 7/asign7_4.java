import java.util.*;

public class asign7_4 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int temp = sc.nextInt();
        double dec = 0;
        int i = 0;
        int temp = temp;
        while (temp != 0) {
            Double bv = Math.pow(2, i);
            int digit = temp % 10;
            dec = dec + bv * digit;
            temp = temp / 10;
            i++;
        }
        System.out.println((int) (dec));

    }
}
