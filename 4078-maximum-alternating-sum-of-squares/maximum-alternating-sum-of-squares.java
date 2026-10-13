class Solution {
    public long maxAlternatingSum(int[] nums) {
      long arr[]=new long[nums.length];
      for(int i=0;i<arr.length;i++){
        arr[i]=(long)nums[i]*nums[i];
      }  
      long sum=0;
      Arrays.sort(arr);
      for(int i=0;i<arr.length;i++){
        if(i<arr.length/2){
            sum=sum-arr[i];
        }
        else{
            sum+=arr[i];
        }
      }
      return sum;
    }
}