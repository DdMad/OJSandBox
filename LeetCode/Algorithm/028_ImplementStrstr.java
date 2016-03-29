/*

Implement strStr().

Returns the index of the first occurrence of needle in haystack, or -1 if needle is not part of haystack.

*/

public class Solution {
    public int strStr(String haystack, String needle) {
        int haystackSize = haystack.length();
        int needleSize = needle.length();
        
        if (needleSize > haystackSize) {
            return -1;
        }
        
        if (needleSize == 0) {
            return 0;
        }
        
        for (int i = 0; i < haystackSize - needleSize + 1; i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                boolean find = true;
                
                for (int j = 1; j < needleSize; j++) {
                    if (haystack.charAt(i + j) != needle.charAt(j)) {
                        find = false;
                        break;
                    }
                }
                
                if (find) {
                    return i;
                } else {
                    continue;
                }
            }
        }
        
        return -1;
    }
}