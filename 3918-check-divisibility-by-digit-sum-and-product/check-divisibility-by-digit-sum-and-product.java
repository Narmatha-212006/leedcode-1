class Solution {
    public boolean checkDivisibility(int n) {
        int temp=n;
        int sum=0;
        int prod=1;
        boolean a=false; 
        while(n>0){
            int m=n%10;
            sum=sum+m;
            prod=prod*m;
            n=n/10;
        }
       int r=sum+prod;
       if(r==0){
        return false;
       }
       return temp%r==0;
    }
}