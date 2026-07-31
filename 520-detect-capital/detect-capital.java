class Solution {
    public boolean detectCapitalUse(String s) {
        int n = s.length();
        int cnt = 0;
        for(int i = 0; i < n; i++){
            if(Character.isUpperCase(s.charAt(i))){
                cnt++;
            }
        }
        if(cnt == n) return true;
        if(cnt == 0) return true;
        if(cnt == 1 && Character.isUpperCase(s.charAt(0))) return true;
        return false;
    }
}