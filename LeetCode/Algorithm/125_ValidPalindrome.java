/*

Given a string, determine if it is a palindrome, considering only alphanumeric characters and ignoring cases.

For example,
"A man, a plan, a canal: Panama" is a palindrome.
"race a car" is not a palindrome.

Note:
Have you consider that the string might be empty? This is a good question to ask during an interview.

For the purpose of this problem, we define empty string as valid palindrome.

Subscribe to see which companies asked this question

*/

public class Solution {
    public boolean isPalindrome(String s) {
        if (s == null) {
            return false;
        }
        
        s = s.trim().toLowerCase();
        
        if (s.length() <= 1) {
            return true;
        }
        
        int l = 0;
        int r = s.length() - 1;
        
        // The valid characters should include '0'-'9' and 'a'-'z' after s.toLowerCase()
        while (l < r) {
            while (l < r && (s.charAt(l) < '0' || (s.charAt(l) > '9' && s.charAt(l) < 'a') || s.charAt(l) > 'z')) {
                l++;
            }
            if (l == r) {
                return true;
            }
            
            while (l < r && (s.charAt(r) < '0' || (s.charAt(r) > '9' && s.charAt(r) < 'a') || s.charAt(r) > 'z')) {
                r--;
            }
            if (l == r) {
                return true;
            }
            
            if (s.charAt(l) != s.charAt(r)) {
                return false;
            } else {
                l++;
                r--;
            }
        }
        
        return true;
    }
}