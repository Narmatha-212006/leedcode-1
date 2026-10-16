class Solution {
    public int sumOfSquares(int[] nums) {
       int n=nums.length;
       int index=0;
       int sum=0;
       for(int i=0;i<nums.length;i++){
        int j=i+1;
        if(n%j==0){
           sum+=nums[i]*nums[i]; 
        }
       } 
       return sum;
    }
}