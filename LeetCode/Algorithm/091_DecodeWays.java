/*

A message containing letters from A-Z is being encoded to numbers using the following mapping:

'A' -> 1
'B' -> 2
...
'Z' -> 26
Given an encoded message containing digits, determine the total number of ways to decode it.

For example,
Given encoded message "12", it could be decoded as "AB" (1 2) or "L" (12).

The number of ways decoding "12" is 2.

*/

public class Solution {
    public int numDecodings(String s) {
        // if s is null
        if (s == null) {
            return 0;
        }
        
        // if s is ""
        if (s.length() == 0) {
            return 0;
        }
        
        // if s is 0xxxxxx...
        if (s.charAt(0) == '0') {
            return 0;
        }
        
        // if s is 1-9 or else
        if (s.length() == 1) {
            if (s.charAt(0) >= '1' && s.charAt(0) <= '9') {
                return 1;
            } else {
                return 0;   
            }
        }
        
        // if s is 30xxx..., 40xxx..., 50xxx...,...
        if (s.charAt(0) > '2' && s.charAt(1) == '0') {
            return 0;
        }
        
        int[] f = new int[s.length()];
        f[0] = 1;
        f[1] = 1;
        if ((s.charAt(0) == '1' && s.charAt(1) > '0' && s.charAt(1) <= '9') ||
            (s.charAt(0) == '2' && s.charAt(1) <= '6' && s.charAt(1) > '0')) {
            f[1] += 1;
        }
        
        for (int i = 2; i < s.length(); i++) {
            char temp = s.charAt(i);
            // if s[i] is non numerical char
            if (temp < '0' || temp > '9') {
                return 0;
            }

            char prev = s.charAt(i - 1);
            if ((prev == '1' && temp != '0') || (prev == '2' && temp <= '6' && temp > '0')) {
                // if previous and current is 11-19 or 21-26
                f[i] += f[i - 1] + f[i - 2];
            } else if ((prev == '1' && temp == '0') || (prev == '2' && temp == '0')) {
                // if previous and current is 10 or 20
                f[i] += f[i - 2];
            } else if ((prev == '2' && temp > '6') || (prev > '2' && temp != '0') || (prev == '0' && temp != '0')) {
                // if previous and current is >27 or 31-39, 41-49, ... or 01-09 
                f[i] += f[i - 1];
            } else {
                // Invalid
                return 0;
            }
        }
        
        return f[s.length() - 1];
    }
}