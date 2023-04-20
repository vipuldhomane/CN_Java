package Arrays;

public class FindDuplicate {
    public static int findDuplicate(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < (n - 1); i++) {
            for (int j = i + 1; j < n; j++) {
                if (arr[i] == arr[j]) {
                    return arr[i];
                }
            }
        }
        return Integer.MAX_VALUE;
    }

    public static void main(String[] args) {
        int array[] = { 1, 5, 6, 8, 9, 54, 47, 8, 58, 7, 8, 5 };
        System.out.println(findDuplicate(array));
    }
}
