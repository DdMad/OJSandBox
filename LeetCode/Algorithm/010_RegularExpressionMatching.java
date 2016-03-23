/*

Implement regular expression matching with support for '.' and '*'.

'.' Matches any single character.
'*' Matches zero or more of the preceding element.

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "a*") → true
isMatch("aa", ".*") → true
isMatch("ab", ".*") → true
isMatch("aab", "c*a*b") → true

*/

public class Solution {
    public boolean isMatch(String s, String p) {
        if (s.length() != 0 && p.length() == 0) {
            return false;
        }
        
        if (p.equals(".*")) {
            return true;
        }
        
        boolean[][] f = new boolean[s.length() + 1][p.length() + 1];
        
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 0; j <= p.length(); j++) {
                f[i][j] = false;
            }
        }
        
        f[0][0] = true;
        
        for (int i = 0; i <= s.length(); i++) {
            for (int j = 1; j <= p.length(); j++) {
                if (p.charAt(j - 1) != '.' && p.charAt(j - 1) != '*') {
                    if (i > 0 && s.charAt(i - 1) == p.charAt(j - 1) && f[i - 1][j - 1]) {
                        f[i][j] = true;
                    }
                } else if (p.charAt(j - 1) == '.') {
                    if (i > 0 && f[i - 1][j - 1]) {
                        f[i][j] = true;
                    }
                } else if (p.charAt(j - 1) == '*' && j > 1) {
                    if (f[i][j -2] || f[i][j - 1]) {
                        f[i][j] = true;
                    } else {
                        if (i > 0 && (p.charAt(j - 2) == '.' || s.charAt(i - 1) == p.charAt(j - 2)) && f[i - 1][j]) {
                            f[i][j] = true;
                        }
                    }
                }
            }
        }
        
        return f[s.length()][p.length()];
    }
}