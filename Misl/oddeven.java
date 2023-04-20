import java.util.*;

public class oddeven {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int sumeven = 0;
        int sumodd = 0;
        int i = 0;
        while (i <= n) {
            if (i % 2 == 0) {
                sumeven += i;
                i++;
            } else {
                sumodd += i;
                i++;
            }
        }
        System.out.println(sumeven);
        System.out.println(sumodd);
    }
}
