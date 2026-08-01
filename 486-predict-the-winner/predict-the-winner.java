class Solution {
    public boolean predictTheWinner(int[] nums) {
      int n=nums.length;
      int s[]=new int[n];
      for(int i=0;i<nums.length;i++){
        s[i]=nums[i];
      }
      for(int i=1;i<s.length;i++){
        for(int j=0;j<n-i;j++){
            int h=j+i;
            s[j]=Math.max(nums[j]-s[j+1],nums[h]-s[j]);
        }
      }
      return s[0]>=0;
    }
}