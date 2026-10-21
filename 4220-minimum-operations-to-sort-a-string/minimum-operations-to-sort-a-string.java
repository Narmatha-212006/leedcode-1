import java.util.Arrays;

public class Solution {
    public int minOperations(String s) {
        int n = s.length();
        
        char[] chars = s.toCharArray();
        char[] sortedChars = s.toCharArray();
        Arrays.sort(sortedChars);
        if (Arrays.equals(chars, sortedChars)) {
            return 0;
        }
        
        if (n == 2) {
            return -1;
        }
        
        char minChar = sortedChars[0];
        char maxChar = sortedChars[n - 1];
        
        if (chars[0] == minChar || chars[n - 1] == maxChar) {
            return 1;
        }
        
        if (chars[0] == maxChar && chars[n - 1] == minChar) {
            boolean hasTargetInMiddle = false;
            for (int i = 1; i < n - 1; i++) {
                if (chars[i] == minChar || chars[i] == maxChar) {
                    hasTargetInMiddle = true;
                    break;
                }
            }
            return hasTargetInMiddle ? 2 : 3;
        }
        
        return 2;
    }
}
