import java.util.*;

/**
 * Arrays1
 */
public class Arrays1 {
    public static void main(String[] args) {
        // Write your code here
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int arr[] = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int d = arr[1] - arr[0];
        boolean ans = true;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] != d) {
                ans = false;
                break;
            }
        }
        System.out.println(ans);
        // sc.close();

    }
}
