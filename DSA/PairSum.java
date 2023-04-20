package DSA;

import java.util.Arrays;

public class PairSum {
    public static int pairSum(int arr[], int num) {
        Arrays.sort(arr);
        int startIndex = 0;
        int endIndex = (arr.length - 1);

        int numPair = 0;

        while (startIndex < endIndex) {
            if (arr[startIndex] + arr[endIndex] < num) {
                startIndex++;
            } else if (arr[startIndex] + arr[endIndex] > num) {
                endIndex--;
            } else {
                // This portion is for array of all same elements

                int elementAtStart = arr[startIndex];
                int elementAtEnd = arr[endIndex];

                if (elementAtStart == elementAtEnd) {
                    int totalElementsFromStartToEnd = (endIndex - startIndex) + 1;
                    numPair += (totalElementsFromStartToEnd * (totalElementsFromStartToEnd - 1) / 2);

                    return numPair;
                }
                int tempStartIndex = startIndex + 1;
                int tempEndIndex = endIndex - 1;
                while (tempStartIndex <= tempEndIndex && arr[tempStartIndex] == elementAtStart) {
                    tempStartIndex++;
                }
                while (tempStartIndex <= tempEndIndex && arr[tempEndIndex] == elementAtEnd) {
                    tempEndIndex--;
                }
                int totalElementsFromStart = (tempStartIndex - startIndex);
                int totalElementsFromEnd = (endIndex - tempEndIndex);
                numPair += (totalElementsFromEnd * totalElementsFromStart);
                startIndex = tempStartIndex;
                endIndex = tempEndIndex;
            }
        }
        return numPair;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 2, 2, 2, 6, 7, 7, 7, 7, 7, 8, 9 };
        // int arr[] = { 1, 3, 3, 4, 5, 6, 8, 9, 9, 9, 15 };
        System.out.println(pairSum(arr, 9));
    }
}
