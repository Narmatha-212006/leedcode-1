class Solution {
    public boolean areOccurrencesEqual(String s) {
       int f[]=new int[26];
       for(int i=0;i<s.length();i++){
        f[s.charAt(i)-'a']++;
       } 
       int target=f[s.charAt(0)-'a'];
       for(int i:f){
        if(i>0){
         if(i!=target){
            return false;
         }
        }
       }
       return true;  
    }
}