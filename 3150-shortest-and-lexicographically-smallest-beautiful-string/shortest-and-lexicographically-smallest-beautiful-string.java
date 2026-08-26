class Solution {
    public String shortestBeautifulSubstring(String s, int k) {
        int left = 0;
        int ones = 0;
        int minLen = Integer.MAX_VALUE;
        String ans = "";
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '1') {
                ones++;
            }
            while (ones == k) {
                int currentLen =i- left + 1;
                String currentSubstring = s.substring(left,i+ 1);
                if (currentLen < minLen) {
                    minLen = currentLen;
                    ans = currentSubstring;
                } 
                else if (currentLen == minLen) {
                    if (currentSubstring.compareTo(ans) < 0) {
                        ans = currentSubstring;
                    }
                }
                if (s.charAt(left) == '1') {
                    ones--;
                }
                left++;
            }
        }

        return ans;
    }
}
