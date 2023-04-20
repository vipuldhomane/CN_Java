
import java.util.*;

public class Far_to_cel {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int s, e, w, step;
        s = sc.nextInt();
        e = sc.nextInt();
        w = sc.nextInt();

        step = s;
        int c;
        while (step <= e) {
            c = (int) (5.0 / 9.0 * (step - 32));
            System.out.println(step + " " + c);
            step += w;
        }
    }
}