package DSA;

import java.util.*;

public class TripletSum {
    public static int pairSum(int arr[], int startIndex, int endIndex, int num) {
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

    public static int tripletSum(int arr[], int num) {
        Arrays.sort(arr);
        int numTriplets = 0;
        for (int i = 0; i < arr.length; i++) {
            int numPairfor = num - arr[i];
            int pairSum = pairSum(arr, i + 1, arr.length - 1, numPairfor);
            numTriplets += pairSum;
        }
        return numTriplets;
    }

    public static void main(String[] args) {
        int arr[] = { 2, 2, 2, 2, 2 };
        System.out.println(tripletSum(arr, 6));
    }
}
