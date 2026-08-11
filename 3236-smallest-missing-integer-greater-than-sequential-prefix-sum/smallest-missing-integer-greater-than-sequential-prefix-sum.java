class Solution {
    public int missingInteger(int[] nums) {
     HashSet<Integer> set=new HashSet<>();
     int prefixsum=nums[0];
      for(int i=1;i<nums.length;i++){
        if(nums[i]==nums[i-1]+1){
          prefixsum+=nums[i]; 
        }
        else{
            break;
        }
      }  
      for(int i:nums){
        set.add(i);
      }
      while(set.contains(prefixsum)){
        prefixsum++;
      }
      return prefixsum;
    }
}
