class Solution {
    public int mostFrequentEven(int[] nums) {
        int f[]=new int[100001];
        for(int i=0;i<nums.length;i++){
            if(nums[i]%2==0){
            f[nums[i]]++;
           }
        }
        int ans=-1;
        int max=0;
        for(int i=0;i<=100000;i++){
            if(f[i]>max){
                max=f[i];
                ans=i;
            }
        }
        return ans;

    }
}