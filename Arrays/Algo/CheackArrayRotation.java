package Arrays.Algo;

/**
 * CheackArrayRotation
 */
public class CheackArrayRotation {

    public static int arrayRotation(int arr[]) {
        int n = arr.length;
        int rotate = 0;
        for (int i = 0; i < n - 1; i++) {
            if (arr[i + 1] < arr[i]) {
                rotate = i + 1;
            }
        }
        return rotate;
    }

    public static void main(String[] args) {
        int array[] = { 5, 8, 9, 1, 3, 4 };
        System.out.println(arrayRotation(array));
    }
}