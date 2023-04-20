package Arrays;

public class ArrayEquilibriumInd {
    public static int arrayEquilibriumInd(int arr[]) {
        int Rightsum = 0;
        for (int i = 0; i < arr.length; i++) {
            Rightsum += arr[i];
        }
        int leftsum = 0;
        for (int i = 0; i < arr.length; i++) {
            Rightsum -= arr[i];
            if (Rightsum == leftsum) {
                return i;
            } else {
                leftsum += arr[i];
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 3, 10, -10, 4, 2, 9 };
        System.out.println(arrayEquilibriumInd(arr));
    }
}
