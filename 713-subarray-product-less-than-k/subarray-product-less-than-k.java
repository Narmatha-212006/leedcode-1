class Solution {
    public int numSubarrayProductLessThanK(int[] nums, int k) {
        int max=0;
        for(int i=0;i<nums.length;i++){
           int count=0;
           int prod=1;
            for(int j=i;j<nums.length;j++){
               prod*=nums[j];
               if(prod<k){
                count++;
                max++;
               } 
              if(prod>=k){
                break;
              }
            }
        }
        return max;
    }
}