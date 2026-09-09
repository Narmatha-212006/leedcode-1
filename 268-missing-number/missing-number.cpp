class Solution {
public:
    int missingNumber(vector<int>& nums) {
      int sum=0;
      int n=nums.size();
      for(int i=0;i<nums.size();i++){
        sum+=nums[i];
      }
      //int t=n*(n+1)/2;
      int current=0;
      for(int i=1;i<(n+1);i++){
        current+=i;
      }
      return abs(current-sum);  
    }
};