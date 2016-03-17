/*

Given a string S, find the longest palindromic substring in S. You may assume that the maximum length of S is 1000, and there exists one unique longest palindromic substring.

Use Manacher Algorithm: O(n)
try to avoid using string to do operation directly

*/

public class Solution {
    public String longestPalindrome(String s) {
        if (s.length() <= 1) {
            return s;
        }
        
        String newString = addHelperChar(s);
        int[] p = new int[newString.length()];
        int maxId = 0;
        int maxRange = 0;
        
        for (int i = 1; i < newString.length(); i ++) {
            p[i] = maxRange > i ? (p[2 * maxId - i] < maxRange - i ? p[2 * maxId - i] : maxRange - i) : 1;
            while (i - p[i] > 0
                && i + p[i] < newString.length()
                && newString.charAt(i + p[i]) == newString.charAt(i - p[i])) {
                    p[i]++;
            }
            if (maxRange < p[i]) {
                maxId = i;
                maxRange = p[i];
            }
        }
        
        char[] result = new char[s.length()];
        int k = 0;
        for (int i = maxId - maxRange + 1; i < maxId + maxRange; i ++) {
            char temp = newString.charAt(i);
            if (temp != '#') {
                result[k ++] = temp;
            }
        }
        
        return new String(result, 0, k);
    }
    
    public String addHelperChar(String s) {
        char[] t = new char[s.length() * 2 + 3];
        t[0] = '$';
        t[s.length() * 2 + 2] = '%';
        
        for (int i = 0; i < s.length(); i ++) {
            t[2 * i + 1] = '#';
            t[2 * i + 2] = s.charAt(i);
        }
        t[s.length() * 2 + 1] = '#';
        
        return new String(t, 0, t.length);
    }
}