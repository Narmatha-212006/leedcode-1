class Solution {
    public List<List<Integer>> subsets(int[] nums) {
       List<List<Integer>> result=new ArrayList<>();
       List<Integer> list=new ArrayList<>();
      subset(0,nums,result,list);
      return result;
    }
    void subset(int index,int nums[],List<List<Integer>>result,List<Integer>list){
      if(index==nums.length){
        result.add(new ArrayList<>(list));
        return;
      }
      list.add(nums[index]);
      subset(index+1,nums,result,list);
      list.remove(list.size()-1);
      subset(index+1,nums,result,list);
 
    }
}