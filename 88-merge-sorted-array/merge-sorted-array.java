class Solution {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        int len=m+n;
        int temp=0;
        for(int i=0; i<n;i++)
        {
            nums1[m+i]=nums2[i];  
        }
        for(int i=0;i<len;i++)
        {
            for(int j=i+1;j<len;j++)
            {
                if(nums1[i]>nums1[j])
                {
                    temp = nums1[i];
                    nums1[i]=nums1[j];
                    nums1[j]=temp;
                }
            }
        }
    }
}