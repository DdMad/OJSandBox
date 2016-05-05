/*

Given a string S and a string T, find the minimum window in S which will contain all the characters in T in complexity O(n).

For example,
S = "ADOBECODEBANC"
T = "ABC"
Minimum window is "BANC".

Note:
If there is no such window in S that covers all characters in T, return the empty string "".

If there are multiple such windows, you are guaranteed that there will always be only one unique minimum window in S.

*/

public class Solution {
    public String minWindow(String s, String t) {
        if (s == null || t == null || s.length() == 0 || t.length() == 0 || s.length() < t.length()) {
            return "";
        }
        
        int left = -1;
        int right = -1;
        int minLeft = -1;
        int minRight = -1;
        int minLength = -1;
        
        // Create map that contains the char of T
        int[] mapT = new int[128];
        for (int i = 0; i < t.length(); i++) {
            char temp = t.charAt(i);
            mapT[(int)temp]++;
        }
        
        // Get the start index (first char in S that is shown in the T)
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (mapT[(int)temp] > 0) {
                left = i;
                right = i;
                break;
            }
        }
        
        if (left == -1) {
            return "";
        }
        
        // Scan through S until find enough char to cover T by moving the right pointer
        int[] tempMap = new int[128];
        int tempCount = 0;
        while (right < s.length()) {
            int temp1 = (int)(s.charAt(right));
            if (mapT[temp1] > 0) {
                tempMap[temp1]++;
                
                if (tempMap[temp1] <= mapT[temp1]) {
                    tempCount++;
                }
            }
            
            // Find substring of s that contains t
            if (tempCount == t.length()) {
                int temp2 = (int)(s.charAt(left));
                // Increase left pointer 
                // Unitl it is the current(before right pointer) least substring that contains T
                while (mapT[temp2] == 0 || mapT[temp2] < tempMap[temp2]) {
                    tempMap[temp2]--;
                    temp2 = (int)(s.charAt(++left));
                }
                
                if (minLength == -1 || right - left + 1 < minLength) {
                    minLength = right - left + 1;
                    minLeft = left;
                    minRight = right;
                }
            }
            right++;
        }
        
        if (minLeft == -1) {
            return "";
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = minLeft; i <= minRight; i++) {
            sb.append(s.charAt(i));
        }
        
        return sb.toString();
    }
}