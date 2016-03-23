/*

Given a roman numeral, convert it to an integer.

Input is guaranteed to be within the range from 1 to 3999.

*/

public class Solution {
    public int romanToInt(String s) {
        if (s.length() == 0) {
            return 0;
        }
        
        int result = charToInt(s.charAt(0));
        for (int i = 1; i < s.length(); i++) {
            int previous = charToInt(s.charAt(i - 1));
            int current = charToInt(s.charAt(i));
            
            if (previous < current) {
                result = result - previous + (current - previous);
            } else {
                result += current;
            }
        }
        
        return result;
    }
    
    public int charToInt(char c) {
        if (c == 'I') {
            return 1;
        }
        if (c == 'V') {
            return 5;
        }
        if (c == 'X') {
            return 10;
        }
        if (c == 'L') {
            return 50;
        }
        if (c == 'C') {
            return 100;
        }
        if (c == 'D') {
            return 500;
        }
        if (c == 'M') {
            return 1000;
        }
        return 0;
    }
}