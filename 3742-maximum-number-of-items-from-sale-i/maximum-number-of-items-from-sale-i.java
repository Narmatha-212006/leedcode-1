import java.util.*;

class Solution {
    public int maximumSaleItems(int[][] items, int budget) {
        int n = items.length;
        int maxVal = 1500;
        for (int[] it : items) {
            if (it[0] > maxVal) {
                maxVal = it[0];
            }
        }

        int[] freq = new int[maxVal + 1];
        for (int i = 0; i < n; i++) {
            freq[items[i][0]]++;
        }

        int[] divisibleCount = new int[maxVal + 1];
        for (int d = 1; d <= maxVal; d++) {
            for (int m = d; m <= maxVal; m += d) {
                divisibleCount[d] += freq[m];
            }
        }

        int[] bonus = new int[n];
        for (int i = 0; i < n; i++) {
            int f = items[i][0];
            bonus[i] = divisibleCount[f] - 1;
        }

        final int NEG_INF = -1_000_000_000;
        int[] dp = new int[budget + 1];
        Arrays.fill(dp, NEG_INF);
        dp[0] = 0;

        for (int i = 0; i < n; i++) {
            int price = items[i][1];
            int firstGain = 1 + bonus[i];
            int[] next = Arrays.copyOf(dp, budget + 1);

            for (int c = budget; c >= price; c--) {
                if (dp[c - price] != NEG_INF) {
                    next[c] = Math.max(next[c], dp[c - price] + firstGain);
                }
            }

            for (int c = price; c <= budget; c++) {
                if (next[c - price] != NEG_INF) {
                    next[c] = Math.max(next[c], next[c - price] + 1);
                }
            }

            dp = next;
        }

        int ans = 0;
        for (int c = 0; c <= budget; c++) {
            if (dp[c] > ans) {
                ans = dp[c];
            }
        }
        return ans;
    }
}
