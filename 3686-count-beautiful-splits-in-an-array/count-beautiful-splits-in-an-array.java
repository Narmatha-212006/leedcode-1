class Solution {
    public int beautifulSplits(int[] nums) {
        int n = nums.length;
        int[][] lcp = new int[n + 1][n + 1];
        int ans = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (nums[i] == nums[j]) {
                    lcp[i][j] = lcp[i + 1][j + 1] + 1;
                }
            }
        }

        for (int i = 1; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                int len1 = i;
                int len2 = j - i;

                if (len1 <= len2 && lcp[0][i] >= len1) {
                    ans++;
                } else if (len2 <= n - j && lcp[i][j] >= len2) {
                    ans++;
                }
            }
        }

        return ans;
    }
}