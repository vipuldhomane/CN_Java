package Arrays;

public class TripletSum {
    public static int pairSum(int arr[], int x) {
        int n = arr.length;
        int count = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                for (int k = j + 1; k < n; k++)
                    if (arr[i] + arr[j] + arr[k] == x) {
                        count += 1;
                    }
            }
        }
        return count;
    }

    public static void main(String[] args) {
        int array[] = { 2, 3, 5, 8, 9, 7, 1, 4, -1 };
        System.out.println(pairSum(array, 10));
    }
}
