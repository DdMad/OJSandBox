/*

Implement wildcard pattern matching with support for '?' and '*'.

'?' Matches any single character.
'*' Matches any sequence of characters (including the empty sequence).

The matching should cover the entire input string (not partial).

The function prototype should be:
bool isMatch(const char *s, const char *p)

Some examples:
isMatch("aa","a") → false
isMatch("aa","aa") → true
isMatch("aaa","aa") → false
isMatch("aa", "*") → true
isMatch("aa", "a*") → true
isMatch("ab", "?*") → true
isMatch("aab", "c*a*b") → false

*/

public class Solution {
    public boolean isMatch(String s, String p) {
        int i = 0;
        int j = 0;
        int sIndex = -1;
        int pIndex = -1;
        
        while (i < s.length()) {
            if ((j < p.length()) && ((s.charAt(i) == p.charAt(j)) || (p.charAt(j) == '?'))) {
                i++;
                j++;
            } else if (j < p.length() && p.charAt(j) == '*') {
                sIndex = i;
                pIndex = j++;
            } else if (pIndex != -1) {
                i = ++sIndex;
                j = pIndex + 1;
            } else {
                return false;
            }
        }
        
        while (j < p.length() && p.charAt(j) == '*') {
            j++;
        }
        
        return j == p.length();
    }
}