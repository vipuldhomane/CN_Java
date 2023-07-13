package Arrays.Algo;

public class SecondLargest {
    public static int secondLargest(int arr[]) {
        int n = arr.length;
        int l = Integer.MIN_VALUE;
        int s = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > l) {
                s = l;
                l = arr[i];
            } else if (arr[i] > s && arr[i] != l) {
                s = arr[i];
            }
        }
        return s;
    }

    public static void main(String[] args) {
        int array[] = { 8, 9, 9, 1, 7, 5, 5, 10, 1, 0, 7 };
        System.out.println(secondLargest(array));
    }

}
