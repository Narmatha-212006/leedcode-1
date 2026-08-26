class Solution {
    public int[] frequencySort(int[] nums) {
      Map<Integer, Integer> map = new HashMap<>();
     for(int i:nums){
        map.put(i,map.getOrDefault(i,0)+1);
     }  
      List<Integer> list = new ArrayList<>();
        for (int num:nums) {
            list.add(num);
        }
         list.sort((a, b) -> {
            int A = map.get(a);
            int B = map.get(b);
              if (A != B) {
                return A - B;
            }
            return b-a;
         });
         for (int i = 0; i < nums.length; i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }
}