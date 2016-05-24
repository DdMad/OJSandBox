/*

Given a string s1, we may represent it as a binary tree by partitioning it to two non-empty substrings recursively.

Below is one possible representation of s1 = "great":

    great
   /    \
  gr    eat
 / \    /  \
g   r  e   at
           / \
          a   t
To scramble the string, we may choose any non-leaf node and swap its two children.

For example, if we choose the node "gr" and swap its two children, it produces a scrambled string "rgeat".

    rgeat
   /    \
  rg    eat
 / \    /  \
r   g  e   at
           / \
          a   t
We say that "rgeat" is a scrambled string of "great".

Similarly, if we continue to swap the children of nodes "eat" and "at", it produces a scrambled string "rgtae".

    rgtae
   /    \
  rg    tae
 / \    /  \
r   g  ta  e
       / \
      t   a
We say that "rgtae" is a scrambled string of "great".

Given two strings s1 and s2 of the same length, determine if s2 is a scrambled string of s1.

*/

public class Solution {
    public boolean isScramble(String s1, String s2) {
        if (s1 == null || s1.length() == 0) {
            return s1 == s2 ? true : false;
        }
        
        if (s1.length() != s2.length()) {
            return false;
        }
        
        // Initialization
        int len = s1.length();
        boolean[][][] f = new boolean[len + 1][len][len];
        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                f[1][i][j] = s1.charAt(i) == s2.charAt(j);
            }
        }
        
        // f[n][i][j]: string length is n, start from ith of s1 and jth of s2, if it is scramble
        for (int n = 1; n <= len; n++) {
            for (int i = 0; i + n <= len; i++) {
                for (int j = 0; j + n <= len; j++) {
                    for (int k = 1; k < n; k++) {
                        if ((f[k][i][j] && f[n - k][i + k][j + k]) || (f[k][i][j + n - k] && f[n - k][i + k][j])) {
                            f[n][i][j] = true;
                            break;
                        }
                    }
                }
            }
        }
        return f[len][0][0];
    }
}