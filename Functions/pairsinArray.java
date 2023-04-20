package Functions;

public class pairsinArray {
    public static void pairs(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < (n - 1); i++) {
            for (int j = i + 1; j < n; j++) {
                System.out.print("(" + arr[i] + "," + arr[j] + ")");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int array[] = { 5, 8, 9, 6, 5, 8, 5 };
        pairs(array);
    }
}
