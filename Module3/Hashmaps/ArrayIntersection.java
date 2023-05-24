package Module3.Hashmaps;

import java.util.*;

public class ArrayIntersection {
    // Two pointer
    public static void intersection(int[] arr1, int[] arr2) {

        Arrays.sort(arr1);
        Arrays.sort(arr2);

        int n = arr1.length;
        int m = arr2.length;

        int i = 0; // pointer to iterate over arr1
        int j = 0; // pointer to iterate over arr2

        while (i < n && j < m) {

            if (arr1[i] == arr2[j]) {
                System.out.print(arr1[i] + " ");
                i += 1;
                j += 1;
            } else if (arr1[i] < arr2[j]) {
                i += 1;
            } else {
                j += 1;
            }

        }
    }

    // using Hashmap
    public static void intersectionhs(int[] arr1, int[] arr2) {
        // Your code goes here
        HashMap<Integer, Integer> map = new HashMap<>();

        for (int key : arr1) {
            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }

        }
        Arrays.sort(arr2);
        for (int key : arr2) {
            if (map.containsKey(key)) {
                int val = map.get(key);
                if (val > 0) {
                    System.out.print(key + " ");
                    map.put(key, val - 1);
                }

            }
        }
    }
}
