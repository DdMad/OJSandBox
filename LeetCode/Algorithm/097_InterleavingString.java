/*

Given s1, s2, s3, find whether s3 is formed by the interleaving of s1 and s2.

For example,
Given:
s1 = "aabcc",
s2 = "dbbca",

When s3 = "aadbbcbcac", return true.
When s3 = "aadbbbaccc", return false.

Show Tags


*/

public class Solution {
    public boolean isInterleave(String s1, String s2, String s3) {
        if (s1 == null || s1 == "") {
            return s2.equals(s3);
        }
        if (s2 == null || s2 == "") {
            return s1.equals(s3);
        }
        if (s1 == null && s2 == null) {
            return s3 == null;
        }
        
        int len1 = s1.length();
        int len2 = s2.length();
        // If length of s3 is not len1 + len2, return false
        if (s3.length() != len1 + len2) {
            return false;
        }
        
        // f[i][j] means s1.substring(0,i) and s2.substring(0,j) can form s3.substring(0,i+j)
        boolean[][] f = new boolean[len1 + 1][len2 + 1];
        f[0][0] = true;
        for (int i = 1; i <= len1; i++) {
            f[i][0] = s1.substring(0, i).equals(s3.substring(0, i));
        }
        for (int i = 1; i <= len2; i++) {
            f[0][i] = s2.substring(0, i).equals(s3.substring(0, i));
        }
        
        for (int i = 1; i <= len1; i++) {
            for (int j = 1; j <= len2; j++) {
                // Whether s1 last char matches s3 last char
                // or s2 last char matches s3 last char
                f[i][j] = (f[i - 1][j] && s1.charAt(i - 1) == s3.charAt(i + j - 1)) ||
                    (f[i][j - 1] && s2.charAt(j - 1) == s3.charAt(i + j - 1));
            }
        }
        return f[len1][len2];
    }
}