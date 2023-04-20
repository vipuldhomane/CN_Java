package Module2.TEST4;

import java.util.*;

public class MaximizeProfit {

    public static int maximumProfit(int budget[]) {
        // Write your code here
        // sort the budget array in ascending order
        Arrays.sort(budget);

        // initialize the maximum profit to zero
        int maxProfit = 0;
        int n = budget.length; // number of customers

        // loop through the budget array from left to right
        for (int i = 0; i < n; i++) {
            // calculate the current profit as the product of the current budget and the
            // remaining customers
            int currentProfit = budget[i] * (n - i);
            // update the maximum profit if the current profit is greater
            maxProfit = Math.max(maxProfit, currentProfit);
        }
        // return the maximum profit
        return maxProfit;

    }

}
