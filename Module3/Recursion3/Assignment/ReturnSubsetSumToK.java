package Module3.Recursion3.Assignment;

public class ReturnSubsetSumToK {
    // Return a 2D array that contains all the subsets which sum to k
    public static int[][] subset(int input[], int si, int k) {
        if (si == input.length) {
            int arr[][];
            if (k == 0) {
                arr = new int[1][0];
            } else {
                arr = new int[0][0];
            }
            return arr;
        }
        int[][] small2 = subset(input, si + 1, k - input[si]);
        int[][] small1 = subset(input, si + 1, k);

        int[][] Output = new int[small1.length + small2.length][];
        for (int i = 0; i < small1.length; i++) {
            Output[i] = new int[small1[i].length];
            for (int j = 0; j < small1[i].length; j++) {
                Output[i][j] = small1[i][j];
            }
        }
        for (int i = 0; i < small2.length; i++) {
            Output[i + small1.length] = new int[small2[i].length + 1];
            Output[i + small1.length][0] = input[si];
            for (int j = 1; j < Output[i + small1.length].length; j++) {
                Output[i + small1.length][j] = small2[i][j - 1];
            }
        }
        return Output;
    }

    public static int[][] subsetsSumK(int input[], int k) {
        // Write your code here
        return subset(input, 0, k);

    }

    // CN Solution
    public static int[][] subsetsSumKHelper(int[] input, int beginIndex, int k) {
        if (beginIndex == input.length) {
            if (k == 0) {
                return new int[1][0];
            } else {
                return new int[0][0];
            }
        }

        int[][] smallOutput1 = subsetsSumKHelper(input, beginIndex + 1, k);
        int[][] smallOutput2 = subsetsSumKHelper(input, beginIndex + 1, k - input[beginIndex]);
        int[][] output = new int[smallOutput1.length + smallOutput2.length][];
        int index = 0;
        for (int i = 0; i < smallOutput1.length; i++) {
            output[index++] = smallOutput1[i];
        }

        for (int i = 0; i < smallOutput2.length; i++) {
            output[index] = new int[smallOutput2[i].length + 1];
            output[index][0] = input[beginIndex];
            for (int j = 0; j < smallOutput2[i].length; j++) {
                output[index][j + 1] = smallOutput2[i][j];
            }
            index++;
        }
        return output;
    }

    public static int[][] subsetsSumKCN(int input[], int k) {
        return subsetsSumKHelper(input, 0, k);
    }
}
/*
 * Return subsets sum to K
 * Send Feedback
 * Given an array A of size n and an integer K, return all subsets of A which
 * sum to K.
 * Subsets are of length varying from 0 to n, that contain elements of the
 * array. But the order of elements should remain same as in the input array.
 * 
 * 
 * Note : The order of subsets are not important.
 * 
 * 
 * Input format :
 * Line 1 : Integer n, Size of input array
 * Line 2 : Array elements separated by space
 * Line 3 : K
 * Constraints :
 * 1 <= n <= 20
 * Sample Input :
 * 9
 * 5 12 3 17 1 18 15 3 17
 * 6
 * Sample Output :
 * 3 3
 * 5 1
 */