class Solution {
    public int findTheLongestBalancedSubstring(String s) {
       int max=0;
       int ones=0;
       int zero=0;
       for(int i=0;i<s.length();i++){
        if(s.charAt(i)=='0'){
            if(ones>0){
                zero=0;
                ones=0;
            }
            zero++;
        }
        else{
            ones++;
        }
        int k=2*Math.min(zero,ones);
        max=Math.max(max,k);
       }
       return max; 
    }
}