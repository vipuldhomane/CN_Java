import java.util.*;

public class Salary_cal {

    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int basic = sc.nextInt();
        char ch = sc.next().charAt(0);
        double hra = 0.20 * basic;
        double da = 0.50 * basic;
        double pf = 0.11 * basic;
        double salary = 0;

        if (ch == 'A') {
            int allow = 1700;
            salary = (basic + hra + da + allow - pf);
            System.out.print(Math.round(salary));

        } else if (ch == 'B') {
            int allow = 1500;
            salary = (basic + hra + da + allow - pf);
            System.out.print(Math.round(salary));
        } else {
            int allow = 1300;
            salary = (basic + hra + da + allow - pf);
            System.out.print(Math.round(salary));
        }

    }
}
