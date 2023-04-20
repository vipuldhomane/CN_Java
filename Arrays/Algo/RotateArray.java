package Arrays.Algo;

public class RotateArray {
    public static void rotateArray(int arr[], int x) {
        int n = arr.length;
        int temp[] = new int[x];

        // adding first two elements of original array to the temp array
        for (int i = 0; i < x; i++) {
            temp[i] = arr[i];
        }
        // shifting elements of original list by X digits
        for (int i = 0; i < n - x; i++) {
            arr[i] = arr[i + x];
        }
        // adding temp[] to original at the end
        int i = (n - x);
        int j = 0;
        while (i < n) {
            arr[i] = temp[j];
            i++;
            j++;
        }

    }

    public static void readarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int array[] = { 4, 1, 5, 2, 7, 5, 6, 9, 5 };
        // System.out.println(array.length);
        // readarray(array);
        rotateArray(array, 2);
        readarray(array);
        // System.out.println(array.length);

    }
}
