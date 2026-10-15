class Solution {
    public int findDuplicate(int[] nums) {
        int j=1;
        int sum=0;
        Arrays.sort(nums);
        for(int i=0;i<nums.length-1;i++){
           if(nums[i]==nums[j]){
             sum=nums[i];
           } 
           j++;
        }
        return sum;
    }
}