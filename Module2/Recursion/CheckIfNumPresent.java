package Module2.Recursion;

public class CheckIfNumPresent {
    private static boolean check(int input[], int x, int si) {
        if (si == input.length) {
            return false;
        }
        if (input[si] == x) {
            return true;
        }
        return check(input, x, si + 1);
    }

    public static boolean check(int input[], int x) {
        return check(input, x, 0);
    }

    public static void main(String[] args) {
        int arr[] = { 1, 6, 5, 6, 5, 4, -6 };
        System.out.println(check(arr, -6));
    }
}
