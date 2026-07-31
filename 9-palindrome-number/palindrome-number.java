class Solution {
    public boolean isPalindrome(int x) {
        int rev=0;
        int n=x;
        while(n>0){
            int dig=n%10;
            rev=rev*10+dig;
            n=n/10;
        }if(x==rev){
            return true;
        }  else{
            return false;
        }
    }
}