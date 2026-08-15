class Solution {
    public int longestSubsequence(int[] nums) {
      boolean a=false;
      int c=0;
      for(int num:nums){
        c^=num;
        if(num!=0){
            a=true;
        }
      }
      if(c!=0){
        return nums.length;
      }
      if(a){
        return nums.length-1;
      }
      return 0;
    }
}