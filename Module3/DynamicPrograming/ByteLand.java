package Module3.DynamicPrograming;

import java.util.HashMap;

public class ByteLand {
    /*
     * Time complexity: O(log(N))
     * Space complexity: O(log(N))
     * 
     * where N is the number of initial bytelandian gold coins
     */
    public static long bytelandianRC(long n) {
        // base case
        if (n == 0) {
            return 0;
        }
        long coins = bytelandianRC(n / 2) + bytelandianRC(n / 3) + bytelandianRC(n / 4);
        long result = Math.max(coins, n);
        return result;
    }

    public static long bytelandianMV(long n, HashMap<Long, Long> memo) {
        // base case
        if (n <= 1) {
            return n;
        }
        // check if the exchange value exists in the hashmap
        if (memo.get(n) != null) {
            return memo.get(n);
        }
        // execution reached here means the value does not exits and we need to
        // calculate the answer
        long exchange = bytelandianMV(n / 2, memo) + bytelandianMV(n / 3, memo) + bytelandianMV(n / 4, memo);
        // now we have the exchange value compare it with the n whichever is max store
        // int map
        long max = Math.max(exchange, n);
        memo.put(n, max);

        // we have the values
        return memo.get(n);
    }

    public static long bytelandian(long n, HashMap<Long, Long> memo) {
        if (n <= 1) {

            return n;
        }

        if (memo.get(n) != null) {
            return memo.get(n);
        }

        long breakDownValue = bytelandian(n / 2, memo) + bytelandian(n / 3, memo) + bytelandian(n / 4, memo);

        memo.put(n, Math.max(n, breakDownValue));

        return memo.get(n);
    }

    public static void main(String[] args) {
        long n = 20;
        HashMap<Long, Long> memo = new HashMap<>();
        long result = bytelandianMV(n, memo);
        System.out.println("The maximum amount of American dollars that can be obtained for " + n
                + " Bytelandian gold coins is " + result);
    }

}
