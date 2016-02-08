/*

Given a string, find the length of the longest substring without repeating characters. For example, the longest substring without repeating letters for "abcabcbb" is "abc", which the length is 3. For "bbbbb" the longest substring is "b", with the length of 1.

*/

public class Solution {
    public int lengthOfLongestSubstring(String s) {
        if (s == null || s.length() == 0) {
            return 0;
        }
        
        int max = 0;
        int beg = 0;
        int end = 0;
        
        int[] a = new int[(int)'~' + 1];
        for (int i = 0; i < a.length; i ++) {
            a[i] = -1;
        }
        
        for (int i = 0; i < s.length(); i ++) {
            if (a[(int)s.charAt(i)] >= beg) {
                max = end - beg + 1 > max ? end - beg + 1 : max;
                beg = a[(int)s.charAt(i)] + 1;
            }
            end = i;
            a[(int)s.charAt(i)] = i;
        }
        
        max = end - beg + 1 > max ? end - beg + 1 : max;
        
        return max;
    }
}