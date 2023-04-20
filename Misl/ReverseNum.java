import java.util.*;

public class ReverseNum {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int orgNum = n;
        int revNum = 0;

        while (orgNum != 0) {
            int ld = orgNum % 10;
            revNum = revNum * 10 + ld;
            orgNum /= 10;
        }

        System.out.println(orgNum);
        System.out.println(revNum);
        if (n == revNum) {
            System.out.println("true");
        } else {
            System.out.println("false");
        }
    }
}
