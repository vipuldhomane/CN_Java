package Arrays.Algo;

public class PushZeros {
    public static void readarray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void pushZeros(int arr[]) {
        int n = arr.length;
        // this code will replace non zero at count index
        int count = 0;
        for (int i = 0; i < n; i++) {
            if (arr[i] != 0) {
                arr[count] = arr[i];
                count++;
            }
        }
        // this code will fill the empty elements with zeros
        while (count < n) {
            arr[count] = 0;
            count++;
        }
    }

    public static void main(String[] args) {
        int array[] = { 1, 4, 2, 4, 0, 2, 5, 0, 0, 4, 5, 0, 0, 3, 1, 2, 0, 1, 2, 4, 200, 0 };
        pushZeros(array);
        readarray(array);
    }
}
