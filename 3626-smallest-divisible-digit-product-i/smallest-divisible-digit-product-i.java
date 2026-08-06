class Solution {
    public int smallestNumber(int n, int t) {
       while(true){
        int h=1;
        int temp=n;
        while(temp>0){
            int j=temp%10;
            h=h*j;
            temp=temp/10;
        }
        if(h%t==0){
            return n;
        }
        n++;
       } 
    }
}