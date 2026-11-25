class Solution {
    public int[] singleNumber(int[] nums) {
        int n=0;
      for(int i=0;i<nums.length;i++){
            n^=nums[i];
      }
      int d=n&-n;
      int s1=0;
      int s2=0;
      for(int num:nums){
        if((d&num)==0){
            s1^=num;
        }
        else{
            s2^=num;
        }
      }
      return new int[]{s1,s2};

    }
}