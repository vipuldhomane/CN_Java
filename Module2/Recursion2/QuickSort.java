package Module2.Recursion2;

public class QuickSort {
    public static int partition(int a[], int si, int ei) {
        int pivotElement = a[si];
        int smallNumCount = 0;
        for (int i = si + 1; i <= ei; i++) {
            if (a[i] < pivotElement) {
                smallNumCount++;
            }
        }
        // swapping pivot ind with si
        int temp = a[si + smallNumCount];
        a[si + smallNumCount] = pivotElement;
        a[si] = temp;

        // Swapping lesser and greater numbers than pivot
        int i = si;
        int j = ei;

        while (i < j) {
            if (a[i] < pivotElement) {
                i++;
            } else if (a[j] >= pivotElement) {
                j--;
            } else {
                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
                i++;
                j--;
            }
        }
        return (si + smallNumCount);

    }

    public static void quickSort(int a[], int si, int ei) {
        // base case
        if (si >= ei) {
            return;
        }
        int pivotIndex = partition(a, si, ei);
        quickSort(a, si, pivotIndex - 1);
        quickSort(a, pivotIndex + 1, ei);
    }

    public static void main(String[] args) {
        int a[] = { 1, 1, 2, 3, 2, 5, 7, 6, 5, 10, 7, 8, 8, 7 };
        quickSort(a, 0, a.length - 1);
        // mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
