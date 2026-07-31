class Solution {
    public int removeDuplicates(int[] nums) {
        int n = nums.length;
        int left =0;
        for(int i=0;i<n;i++){
            if(nums[left]!=nums[i]){
                left++;
                int temp = nums[left];
                nums[left]=nums[i];
                nums[i]=temp;
            }
        }
        return left+1;
    }
}