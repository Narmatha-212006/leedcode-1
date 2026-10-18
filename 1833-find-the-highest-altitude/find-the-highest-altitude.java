class Solution {
    public int largestAltitude(int[] gain) {
      int max=0;
      int s=0;
      for(int i=0;i<gain.length;i++){
        max+=gain[i];
        if(max>s){
            s=max;
        }
      }  
      return s;
    }
}