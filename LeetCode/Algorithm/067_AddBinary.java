/*

Given two binary strings, return their sum (also a binary string).

For example,
a = "11"
b = "1"
Return "100".

*/

public class Solution {
    public String addBinary(String a, String b) {
        int aLen = a.length();
        int bLen = b.length();
        int i = aLen - 1;
        int j = bLen - 1;
        
        StringBuilder sb = new StringBuilder();
        
        char c = '0';
        while (i >= 0 && j >= 0) {
            if (a.charAt(i) == b.charAt(j)) {
                if (c == '0') {
                    sb.insert(0, '0');
                } else {
                    sb.insert(0, '1');
                }
                c = a.charAt(i);
            } else {
                if (c == '0') {
                    sb.insert(0, '1');
                    c = '0';
                } else {
                    sb.insert(0, '0');
                    c = '1';
                }
            }
            
            i--;
            j--;
        }
        
        while (i >= 0) {
            if (c == a.charAt(i)) {
                sb.insert(0, '0');
            } else {
                sb.insert(0, '1');
                c = '0';
            }
            
            i--;
        }
        
        while (j >= 0) {
            if (c == b.charAt(j)) {
                sb.insert(0, '0');
            } else {
                sb.insert(0, '1');
                c = '0';
            }
            
            j--;
        }
        
        if (c == '1') {
            sb.insert(0, '1');
        }
        
        return sb.toString();
    }
}