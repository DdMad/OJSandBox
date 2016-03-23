/*

Given an integer, convert it to a roman numeral.

Input is guaranteed to be within the range from 1 to 3999.

*/

public class Solution {
    public String intToRoman(int num) {
        String[] r = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};
        int[] n = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};
        
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < r.length; i++) {
            while (num >= n[i]) {
                num = num - n[i];
                sb.append(r[i]);
            }
        }
        
        return sb.toString();
    }
}