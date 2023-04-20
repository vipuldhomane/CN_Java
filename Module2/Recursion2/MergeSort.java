package Module2.Recursion2;

public class MergeSort {
    public static void merge(int s1[], int s2[], int d[]) {
        int i = 0;
        int j = 0;
        int k = 0;
        // smaller element get appended to the newly created array

        while (i < s1.length && j < s2.length) {
            if (s1[i] <= s2[j]) {
                d[k] = s1[i];
                i++;
                k++;
            } else {
                d[k] = s2[j];
                j++;
                k++;
            }

        }
        while (i < s1.length) {
            d[k] = s1[i];
            i++;
            k++;
        }
        while (j < s2.length) {
            d[k] = s2[j];
            j++;
            k++;
        }
    }

    public static void mergeSort(int a[]) {
        // dividing original array into two different arrays
        if (a.length <= 1) {
            return;
        }
        int b[] = new int[a.length / 2];
        int c[] = new int[a.length - b.length];

        // append elements to newly created arrays from original

        for (int i = 0; i < a.length / 2; i++) {
            b[i] = a[i];
        }
        for (int i = a.length / 2; i < a.length; i++) {
            c[i - a.length / 2] = a[i];
        }
        // this will break down the whole array into single element array which is
        // sorted
        // because there is no other element hence the array is already sorted.
        // after the array is broken into the pieces the merge sort is performed on each
        // element
        // and each element gets appended to the original array
        mergeSort(b);
        mergeSort(c);
        merge(b, c, a);
    }

    public static void main(String[] args) {
        int a[] = { 5, 4, 7, 6, 1, 2, 1, 0, 10, 4, 5, 7 };
        mergeSort(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
    }
}
