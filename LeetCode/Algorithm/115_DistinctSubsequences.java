/*

Given a string S and a string T, count the number of distinct subsequences of T in S.

A subsequence of a string is a new string which is formed from the original string by deleting some (can be none) of the characters without disturbing the relative positions of the remaining characters. (ie, "ACE" is a subsequence of "ABCDE" while "AEC" is not).

Here is an example:
S = "rabbbit", T = "rabbit"

Return 3.

*/

public class Solution {
    public int numDistinct(String s, String t) {
        if (s == null || t == null) {
            return 0;
        }
        
        if (s.length() < t.length()) {
            return 0;
        }
        
        // f[j] means distinct subsequences of t[0..j-1] and s[0..i-1]
        // Can use 2D array: f[i][j]
        // If s[i-1]=t[j-1], f[i][j] = f[i-1][j-1] + f[i-1][j],
        // else f[i][j] = f[i-1][j]
        // Use rolling array will reduce the space complexity to O(n)
        int[] f = new int[t.length() + 1];
        for (int i = 0; i <= s.length(); i++) {
            // Here must be reverse order
            // Because f[j] may use the value of f[j-1],
            // so you should calculate f[j] then f[j-1]
            // Otherwise f[j-1] will be overwritten first if using asscending order
            for (int j = t.length(); j >=0; j--) {
                if (i < j) {
                    f[j] = 0;
                } else if (j == 0) {
                    // Must set f[0] to 1,
                    // or just iterate 1 to j and set f[0] at the beginning
                    f[j] = 1;
                } else {
                    if (t.charAt(j - 1) == s.charAt(i - 1)) {
                        f[j] = f[j] + f[j - 1];
                    }
                }
            }
        }
        
        return f[t.length()];
    }
}