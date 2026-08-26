class Solution {
    public String frequencySort(String s) {
       int f[]=new int[128];
       for(int i=0;i<s.length();i++){
        f[s.charAt(i)]++;
       }
      StringBuilder sb=new StringBuilder();
      while(sb.length()<s.length()){
        char c=0;
        int max=0;
        for(int i=0;i<128;i++){
            if(f[i]>max){
                max=f[i];
                c=(char)i;
            }
        }
        for(int i=0;i<max;i++){
            sb.append(c);
        }
        f[c]=0;
      }
      return sb.toString();
    }
}