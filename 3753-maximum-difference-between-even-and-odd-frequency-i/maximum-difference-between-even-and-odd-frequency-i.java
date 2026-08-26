class Solution {
    public int maxDifference(String s) {
      int f[]=new int[26];
      for(int i=0;i<s.length();i++){
        f[s.charAt(i)-'a']++;
      } 
      int max=Integer.MAX_VALUE;
      int max2=0;
      for(int i:f){
        if(i>0){
        if(i%2==0){
           max=Math.min(i,max);
        }
        else if(i%2!=0){
            max2=Math.max(i,max2);
        }
        }
      }
      return max2-max;
    }
}