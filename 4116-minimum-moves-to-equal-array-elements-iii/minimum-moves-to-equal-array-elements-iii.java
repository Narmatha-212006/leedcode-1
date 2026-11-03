class Solution {
    public int minMoves(int[] nums) {
        int sum=0;
        int max=nums[0];
      for(int i=0;i<nums.length;i++){
        max=Math.max(nums[i],max);
      }
      for(int i=0;i<nums.length;i++){
        int n=max-nums[i];
        sum+=n;
      }
      return sum;
    }
}