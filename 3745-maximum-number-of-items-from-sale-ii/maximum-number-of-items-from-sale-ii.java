import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        long[] freq = new long[n + 1];
        long minPrice = items[0][1];

        for (int[] it : items) {
            freq[it[0]]++;
            minPrice = Math.min(minPrice, it[1]);
        }

        long[] multCount = new long[n + 1];
        for (int f = 1; f <= n; f++) {
            for (int m = f; m <= n; m += f) {
                multCount[f] += freq[m];
            }
        }

      
        long[][] list = new long[n][2];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            long p = items[i][1];
            long gain = Math.max(0L, multCount[f] - 1);
            list[i][0] = p;
            list[i][1] = gain;
        }

        Arrays.sort(list, Comparator.comparingLong(a -> a[0]));

        long remBudget = budget;
        long totalItems = 0;
        long best = remBudget / minPrice;

        for (long[] entry : list) {
            long price = entry[0];
            long gain = entry[1];
            if (remBudget < price) break;

            long maxAffordable = remBudget / price;
            long boosted = Math.min(gain, maxAffordable);
            totalItems += boosted * 2;
            remBudget -= boosted * price;

           
            long candidate = totalItems + (remBudget / minPrice);
            if (candidate > best) {
                best = candidate;
            }
        }

        return (int) best;
    }
}