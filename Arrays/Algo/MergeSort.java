package Arrays.Algo;

public class MergeSort {
    public static int[] mergeSort(int arr1[], int arr2[]) {
        int n = arr1.length;
        int m = arr2.length;
        int arr[] = new int[m + n];
        int i = 0;
        int j = 0;
        int k = 0;
        // This condition will last till one of arrays end
        while (i < n && j < m) {
            if (arr1[i] <= arr2[j]) {
                arr[k] = arr1[i];
                i++;
                k++;
            } else {
                arr[k] = arr2[j];
                j++;
                k++;
            }
        }
        // this part will append the remaining portion to the newly created array
        while (i < n) {
            arr[k] = arr1[i];
            i++;
            k++;
        }
        while (j < m) {
            arr[k] = arr2[j];
            j++;
            k++;
        }
        return arr;

    }

    public static void readArray(int arr[]) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i] + " ");
        }
    }

    public static void main(String[] args) {
        int arr1[] = { 1, 4, 8, 10, 13, 17 };
        int arr2[] = { 2, 3, 5, 8, 9, 11, 12 };
        int arr[] = mergeSort(arr1, arr2);
        readArray(arr);

    }

}
