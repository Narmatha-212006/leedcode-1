class Solution {
    public int numSquares(int n) {
       if(square(n)){
        return 1;
       } 
       int temp=n;
       while(temp%4==0){
        temp/=4;
       }
       if(temp%8==7){
        return 4;
       }
       for(int i=1;i*i<=n;i++){
          if(square(n-i*i)){
            return 2;
          }
       }
    return 3;
    }
    private boolean square(int n){
        int s=(int)Math.sqrt(n);
        return s*s==n;
    }
}