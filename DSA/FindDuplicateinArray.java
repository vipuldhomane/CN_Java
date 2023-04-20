package DSA;

public class FindDuplicateinArray {
    public static int findDuplicate(int arr[]) {
        // Time complexity is O(n)
        // Sum of Array
        //
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i];
        }
        // Sum of natural numbers Till (N-2)
        int Nsum = ((arr.length - 2) * (arr.length - 1) / 2);

        // Difference Between sum and Nsum(N-2)
        int diff = sum - Nsum;
        return diff;

    }

    public static void main(String[] args) {
        int arr[] = { 2, 1, 0, 4, 3, 4 };
        System.out.println(findDuplicate(arr));
    }
}
