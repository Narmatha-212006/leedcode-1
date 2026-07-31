class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int m=nums1.length;
        int n=nums2.length;
        ArrayList<Integer> list=new ArrayList<>();
        for(int i=0;i<m;i++){
            list.add(nums1[i]);
        }
      for(int i=0;i<n;i++){
        list.add(nums2[i]);
      }
        Collections.sort(list);
        int s=list.size();
       
        if(s%2==0){
            return (list.get(s/2-1)+list.get(s/2))/2.0;
        }
        return (list.get(s/2));
    }
}