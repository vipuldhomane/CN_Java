package FullTest1;

/*Rainbow array
Send Feedback
An array is Rainbow if it has the following structure:
1.  First a1 elements equal 1.
2.  Next a2 elements equal 2.
3.  Next a3 elements equal 3.
4.  Next a4 elements equal 4.
5.  Next a5 elements equal 5.
6.  Next a6 elements equal 6.
7.  Next a7 elements equal 7.
8.  Next a6 elements equal 6.
9.  Next a5 elements equal 5.
10. Next a4 elements equal 4.
11. Next a3 elements equal 3.
12. Next a2 elements equal 2.
13. Next a1 elements equal 1.
(Here a1,a2,a3... are number of elements).
14. ai can be any non-zero positive integer.
15. There are no other elements in array.
Find out if the given array is a Rainbow Array or not.
Input:
The first line of contains an integer N, denoting the number of elements in the given array.
The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of array.
Output:
 Output a line containing "yes" or "no" (without quotes) corresponding to the case if the array is rainbow array or not.
Constraints:
7 ≤ N ≤ 100
1 ≤ Ai ≤ 10
Sample Input 1:
19
1 2 3 4 4 5 6 6 6 7 6 6 6 5 4 4 3 2 1
Sample output 1:
Yes
Sample input 2:
12
1 2 3 4 5 6 6 5 4 3 2 1
Sample output 2:
No
(has no elements with value 7 after elements with value 6.)
Sample output 3:
14
1 1 2 3 4 5 6 7 6 5 4 3 2 1
Sample output 3:
No
(On the left we have two occurrences of 1, whereas on the right only one occurrence ).  */
import java.util.ArrayDeque;

import java.util.HashMap;

class CNSolution {
    public static void israinbow(int[] arr) {
        int N = arr.length;
        if (N < 13) {
            System.out.println("no");
            return;
        }

        int start = 0;
        int end = N - 1;

        boolean isValid = true;

        int cur = 0;

        while (start != end && start < end) {

            if (arr[start] != arr[end]) {
                isValid = false;
                break;
            }

            if (arr[start] < 1 || arr[start] > 7) {
                isValid = false;
                break;
            }

            if (arr[start] != cur) {
                if (arr[start] != cur + 1) {
                    isValid = false;
                    break;
                } else {
                    cur = arr[start];
                }
            }

            start++;
            end--;
        }

        if ((arr[start] == 7 || cur == 7) && isValid) {
            System.out.println("yes");
        } else {
            System.out.println("no");
        }
    }
}

class Solution {

    public static void israinbow(int[] arr) {
        boolean isRainbow = true;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i <= 7; i++)
            hashMap.put(i, 0);
        boolean inc = true;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > 7) {
                isRainbow = false;
                break;
            }
            if (arr[i] == 7) {
                inc = false;
                continue;
            }
            if (inc)
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            else
                hashMap.put(arr[i], hashMap.get(arr[i]) - 1);
        }
        for (int i = 0; i < 7; i++) {
            if (hashMap.get(i) != 0)
                isRainbow = false;
        }
        if (isRainbow)
            System.out.println("yes");
        else
            System.out.println("no");
    }
}

public class RainbowArray {
    public static boolean isRainbow(int arr[]) {
        // boolean present[] = new boolean[8];
        ArrayDeque<Integer> dq = new ArrayDeque<>();
        for (int elem : arr) {
            dq.add(elem);
        }
        while (!dq.isEmpty()) {
            // if (dq.size() == 1 && dq.peek() == 7) {
            // return true;
            // } else {
            System.out.println(dq.size());
            int previous = 0;
            int first = dq.peekFirst();
            int last = dq.peekLast();
            if ((previous == first || previous + 1 == first) && first == last) {
                previous = first;
                dq.pollFirst();
                dq.pollLast();
                System.out.println("present");
            }
        }
        // }
        return false;
    }

    public static void main(String[] args) {
        int arr[] = { 1, 2, 3, 4, 5, 6, 7, 6, 5, 4, 3, 2, 1 };
        System.out.println(isRainbow(arr));
    }
}
