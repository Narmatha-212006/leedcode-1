import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int m = queries.length;
        int[][] sortedQueries = new int[m][2];
        for (int i = 0; i < m; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }

        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));

        int[] ans = new int[m];
        Map<Integer, Integer> countMap = new HashMap<>();
        int left = 0;
        int right = 0;

        for (int i = 0; i < m; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            int startTime = queryTime - x;

            while (right < logs.length && logs[right][1] <= queryTime) {
                int serverId = logs[right][0];
                countMap.put(serverId, countMap.getOrDefault(serverId, 0) + 1);
                right++;
            }

            while (left < logs.length && logs[left][1] < startTime) {
                int serverId = logs[left][0];
                if (countMap.containsKey(serverId)) {
                    int currentCount = countMap.get(serverId);
                    if (currentCount == 1) {
                        countMap.remove(serverId);
                    } else {
                        countMap.put(serverId, currentCount - 1);
                    }
                }
                left++;
            }

            ans[originalIndex] = n - countMap.size();
        }

        return ans;
    }
}
