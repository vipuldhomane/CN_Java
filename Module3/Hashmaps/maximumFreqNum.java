package Module3.Hashmaps;

import java.util.HashMap;

public class maximumFreqNum {
    public static int maxFrequencyNumber(int[] arr) {
        HashMap<Integer, Integer> hm = new HashMap<Integer, Integer>();
        for (int i : arr) {
            if (hm.containsKey(i)) {
                hm.put(i, hm.get(i) + 1);
            } else {
                hm.put(i, 1);
            }
            // hm.put(i, hm.getOrDefault(i, 0) + 1);
        }
        int max = 0, ans = Integer.MIN_VALUE;
        for (int i : arr) {
            if (hm.get(i) > max) {
                max = hm.get(i);
                ans = i;
            }
        }
        return ans;
    }
}
