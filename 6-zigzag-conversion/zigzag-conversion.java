class Solution {
    public String convert(String s, int numRows) {
       if(numRows==1){
         return s;
       }
       StringBuilder a[]=new StringBuilder[numRows];
       for(int i=0;i<numRows;i++){
        a[i]=new StringBuilder();
       } 
       int curr=0;
       boolean down=false;
       for(int i=0;i<s.length();i++){
             char c=s.charAt(i);
              a[curr].append(c);
              if(curr==0|| curr==numRows-1){
                down=!down;
              }
              if(down){
                curr++;
              }
              else{
                curr--;
              }
       } 
       StringBuilder sb=new StringBuilder();
       for(StringBuilder r:a){
       sb.append(r);
       }
       return sb.toString();
    }
}