class Solution {
    public List<List<Integer>> permute(int[] nums) {
       List<List<Integer>> result=new ArrayList<>();
       ArrayList<Integer> list=new ArrayList<>();
       backtrack(nums,result,list); 
       return result;
    }
    void backtrack(int nums[],List<List<Integer>>result,ArrayList<Integer>list){
        if(list.size()==nums.length){
            result.add(new ArrayList<>(list));
            return;
        }
      for(int num:nums){
        if(list.contains(num)){
            continue;
        }
        list.add(num);
        backtrack(nums,result,list);
        list.remove(list.size()-1);

      }
    }

}