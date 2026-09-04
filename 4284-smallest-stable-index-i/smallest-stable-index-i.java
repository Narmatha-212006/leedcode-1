public class Solution {
    public static int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        if (n == 0) return -1;
        int prefixMax = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            prefixMax = Math.max(prefixMax, nums[i]);
            int suffixMin = nums[i];
            for (int j = i + 1; j < n; j++) {
                suffixMin = Math.min(suffixMin, nums[j]);
            }
            if (prefixMax - suffixMin <= k) {
                return i; 
            }
        }

        return -1;
    }
}
