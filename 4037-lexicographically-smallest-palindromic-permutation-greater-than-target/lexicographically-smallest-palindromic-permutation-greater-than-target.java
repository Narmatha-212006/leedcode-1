import java.util.Arrays;

public class Solution {
    private String bestRes;

    public String lexPalindromicPermutation(String s, String target) {
        int[] count = new int[26];
        for (char ch : s.toCharArray()) {
            count[ch - 'a']++;
        }

        int oddCount = 0;
        int oddIdx = -1;
        for (int i = 0; i < 26; i++) {
            if (count[i] % 2 != 0) {
                oddCount++;
                oddIdx = i;
            }
        }
        if (oddCount > 1) return "";

        int n = s.length();
        int halfLen = n / 2;
        int[] halfCount = new int[26];
        for (int i = 0; i < 26; i++) {
            halfCount[i] = count[i] / 2;
        }

        bestRes = null;
        char[] current = new char[halfLen];
        
        solve(0, halfLen, halfCount, current, target, false, n, oddIdx);
        
        return bestRes == null ? "" : bestRes;
    }

    private void solve(int idx, int halfLen, int[] halfCount, char[] current, String target, boolean isGreater, int n, int oddIdx) {
        if (idx == halfLen) {
            StringBuilder sb = new StringBuilder();
            for (char c : current) sb.append(c);
            String left = sb.toString();
            String right = sb.reverse().toString();
            
            String full;
            if (n % 2 == 1) {
                full = left + (char) ('a' + oddIdx) + right;
            } else {
                full = left + right;
            }
            
            if (full.compareTo(target) > 0) {
                if (bestRes == null || full.compareTo(bestRes) < 0) {
                    bestRes = full;
                }
            }
            return;
        }

        int startChar = 0;
        if (!isGreater) {
            startChar = target.charAt(idx) - 'a';
        }

        for (int i = startChar; i < 26; i++) {
            if (halfCount[i] > 0) {
                halfCount[i]--;
                current[idx] = (char) ('a' + i);
                
                boolean nextGreater = isGreater || (i > (target.charAt(idx) - 'a'));
                
                solve(idx + 1, halfLen, halfCount, current, target, nextGreater, n, oddIdx);
                
                halfCount[i]++;
                
                if (nextGreater) {
                    break;
                }
            }
        }
    }
}
