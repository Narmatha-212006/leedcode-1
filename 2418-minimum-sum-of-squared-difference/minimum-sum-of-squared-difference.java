import java.util.Arrays;

class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long totalK = (long) k1 + k2;
        long[] count = new long[100001];
        long maxDiff = 0;
        
        for (int i = 0; i < n; i++) {
            long d = Math.abs((long) nums1[i] - nums2[i]);
            count[(int) d]++;
            maxDiff = Math.max(maxDiff, d);
        }
        
        for (long i = maxDiff; i > 0 && totalK > 0; i--) {
            if (count[(int) i] > 0) {
                long take = Math.min(totalK, count[(int) i]);
                count[(int) i] -= take;
                count[(int) i - 1] += take;
                totalK -= take;
            }
        }
        
        long res = 0;
        for (int i = 1; i <= maxDiff; i++) {
            if (count[i] > 0) {
                res += count[i] * (long) i * i;
            }
        }
        
        return res;
    }
}