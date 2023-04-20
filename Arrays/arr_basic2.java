package Arrays;

public class arr_basic2 {
    public static void readarray(int arr[]) {
        int n = arr.length;
        // arr = new int[7];
        // System.out.println(arr);
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static int[] increment(int arr[]) {
        arr = new int[8];
        for (int i = 0; i < arr.length; i++) {
            arr[i] += 1;
            // System.out.println(arr[i]);
        }
        return arr;
    }

    public static void main(String[] args) {
        int array[] = { 1, 5, 8, 9, 96, 2 };
        // System.out.println(array);
        // readarray(array);
        array = increment(array);
        readarray(array);
    }

}
