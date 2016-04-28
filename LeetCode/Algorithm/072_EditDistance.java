/*

Given two words word1 and word2, find the minimum number of steps required to convert word1 to word2. (each operation is counted as 1 step.)

You have the following 3 operations permitted on a word:

a) Insert a character
b) Delete a character
c) Replace a character

*/

public class Solution {
    public int minDistance(String word1, String word2) {
        if (word1 == null || word2 == null) {
            return 0;
        }
        
        int len1 = word1.length();
        int len2 = word2.length();
        int[][] f = new int[len1 + 1][len2 + 1];
        for (int i = 0; i <= len1; i++) {
            f[i][0] = i;
        }
        for (int i = 0; i <= len2; i++) {
            f[0][i] = i;
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // 3 cases:
                // a. Insert: f[i][j-1] get j-1 char from word2, then add jth char
                // b. Delete: f[i-1][j] get j char from word2, then remove ith char from word1(since already get j char)
                // c. Replace: f[i-1][j-1] get j-1 char from word2, if ith=jth, f[i][j]=f[i-1][j-1]
                //      else f[i][j]=f[i-1][j-1]+1
                f[i][j] = word1.charAt(i - 1) == word2.charAt(j - 1) ? f[i - 1][j - 1] : f[i - 1][j - 1] + 1;
                f[i][j] = min(f[i][j], f[i - 1][j] + 1, f[i][j - 1] + 1);
            }
        }
        return f[len1][len2];
    }
    
    public int min(int x, int y, int z) {
        if (x < y) {
            if (x < z) {
                return x;
            } else {
                return z;
            }
        } else {
            if (y < z) {
                return y;
            } else {
                return z;
            }
        }
    }
}