package Module3.Hashmaps;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

import Arrays.linearSearch;

public class hashmapuse {

    public static ArrayList<Integer> removeDuplicates(int arr[]) {
        ArrayList<Integer> output = new ArrayList<>();
        HashMap<Integer, Boolean> map = new HashMap<>();
        for (int i : arr) {
            if (map.containsKey(i)) {
                continue;
            }
            output.add(i);
            map.put(i, true);
        }
        return output;
    }

    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> map = new HashMap<>();
        // add all the element from the arry to the map
        for (int i : arr) {
            // case 1 if key is present int map
            if (map.containsKey(i)) {
                map.put(i, map.get(i) + 1);
            } else {
                // case 2 if key is not present
                map.put(i, 1);
            }
        }
        // now find the highest value in the map
        int maxCount = 0, maxOccurance = Integer.MIN_VALUE;
        for (int i : arr) {
            if (map.get(i) > maxCount) {
                maxCount = map.get(i);
                maxOccurance = i;
            }

        }
        return maxOccurance;
    }

    public static void intersection(int[] arr1, int[] arr2) {
        HashMap<Integer, Integer> map = new HashMap<>();

        // loop over the arr1 and add all of they with frequency
        for (int key : arr1) {
            // see if it exists in the map or not
            if (map.containsKey(key)) {
                int freq = map.get(key);
                map.put(key, freq + 1);
            } else {
                map.put(key, 1);
            }
        }
        // now traverse the arr2 and find if the key exists in the map
        // if yes then print the key
        // and reduce the freq by one
        for (int key : arr2) {
            if (map.containsKey(key)) {
                int freq = map.get(key);
                if (freq > 0) {
                    System.out.print(key + " ");
                    map.put(key, freq - 1);
                }
            }
        }

    }

    public static void main(String[] args) {
        HashMap<String, Integer> map = new HashMap<>();
        map.put("abc", 12);
        map.put("xyz", 23);
        System.out.println(map.size());
        // int ans = map.get("ab");
        // System.out.println(ans);
        if (map.containsKey("ab")) {
            System.out.println("true it contains ");
        }
        map.clear();
        int arr[] = { 3, 4, 5, 3, 2, 1, 4, 5 };
        int arr2[] = { 3, 4, 9, 3 };
        intersection(arr, arr2);

        // ArrayList<Integer> ans = removeDuplicates(arr);
        // System.out.println(ans);
        // System.out.println(maxFrequencyNumber(arr));
    }

}
