import java.util.Arrays;

public class Solution {
    public int[] validSequence(String word1, String word2) {
        char[] w1 = word1.toCharArray();
        char[] w2 = word2.toCharArray();
        int n = w1.length;
        int m = w2.length;
        
        
        int[] match = new int[m + 1];
        Arrays.fill(match, -1);
        match[m] = n; 
        
        int w1Idx = n - 1;
        for (int i = m - 1; i >= 0; i--) {
            while (w1Idx >= 0 && w1[w1Idx] != w2[i]) {
                w1Idx--;
            }
            if (w1Idx >= 0) {
                match[i] = w1Idx;
                w1Idx--;
            } else {
                break;
            }
        }
        
        int[] result = new int[m];
        boolean changeUsed = false;
        int j = 0; 
        
        for (int i = 0; i < m; i++) {
        
            if (j >= n) {
                return new int[0];
            }
            
            if (w1[j] == w2[i]) {
                result[i] = j;
                j++;
            } 
        
            else if (!changeUsed && j + 1 <= match[i + 1]) {
                result[i] = j;
                changeUsed = true;
                j++;
            }
            else {
                while (j < n && w1[j] != w2[i]) {
                    j++;
                }
                if (j >= n) {
                    return new int[0];
                }
                result[i] = j;
                j++;
            }
        }
        
        return result;
    }
}
