import java.util.Arrays;

class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] cost = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                int len = j - i + 1;
                int minChanges = Integer.MAX_VALUE;

                for (int d = 1; d < len; d++) {
                    if (len % d == 0) {
                        int currentChanges = 0;
                        for (int start = 0; start < d; start++) {
                            int l = i + start;
                            int r = i + len - d + start;
                            while (l < r) {
                                if (s.charAt(l) != s.charAt(r)) {
                                    currentChanges++;
                                }
                                l += d;
                                r -= d;
                            }
                        }
                        minChanges = Math.min(minChanges, currentChanges);
                    }
                }
                cost[i][j] = minChanges;
            }
        }

        int INF = 1000000;
        int[][] dp = new int[k + 1][n + 1];
        for (int[] row : dp) {
            Arrays.fill(row, INF);
        }
        dp[0][0] = 0;

        for (int p = 1; p <= k; p++) {
            for (int i = 1; i <= n; i++) {
                for (int j = 2 * (p - 1); j <= i - 2; j++) {
                    dp[p][i] = Math.min(dp[p][i], dp[p - 1][j] + cost[j][i - 1]);
                }
            }
        }

        return dp[k][n];
    }
}