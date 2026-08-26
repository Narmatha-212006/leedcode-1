class Solution {
    public int percentageLetter(String s, char letter) {
      int count=0;
      for(int i=0;i<s.length();i++){
        char c=s.charAt(i);
        if(c==letter){
            count++;
        }
      } 
      int k=count*100/s.length();
      return k; 
    }
}