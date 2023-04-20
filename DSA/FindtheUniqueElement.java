package DSA;

public class FindtheUniqueElement {
    public static int findUniqueElement(int arr[]) {
        /*
         * a^a =0
         * 0^a =a
         * By doing this only unique item will left
         * 
         */
        int ans = arr[0];
        for (int i = 1; i < arr.length; i++) {
            ans = ans ^ arr[i];
            // System.out.println(ans);
        }
        return ans;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 5, 1, 5 };
        System.out.println(findUniqueElement(arr));
    }
}
