/*

Implement atoi to convert a string to an integer.

Hint: Carefully consider all possible input cases. If you want a challenge, please do not see below and ask yourself what are the possible input cases.

Notes: It is intended for this problem to be specified vaguely (ie, no given input specs). You are responsible to gather all the input requirements up front.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

spoilers alert... click to show requirements for atoi.

Requirements for atoi:
The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned. If the correct value is out of the range of representable values, INT_MAX (2147483647) or INT_MIN (-2147483648) is returned.

*/

public class Solution {
    public int myAtoi(String str) {
        if (str == null || str.length() < 1) {
            return 0;
        }
        
        str = str.trim();
        long result = 0;
        
        boolean first = true;
        int sign = 1;
        
        for (int i = 0; i < str.length(); i++) {
            if (first && (str.charAt(i) == '+' || str.charAt(i) == '-')) {
                first = false;
                
                if (str.charAt(i) == '-') {
                    sign = -1;
                } else {
                    sign = 1;
                }
            } else if (str.charAt(i) >= '0' && str.charAt(i) <= '9') {
                first = false;
                
                result = result * 10 + (int)(str.charAt(i) - '0');
                if (result * sign > Integer.MAX_VALUE) {
                    return Integer.MAX_VALUE;
                } else if (result * sign < Integer.MIN_VALUE) {
                    return Integer.MIN_VALUE;
                }
            } else {
                return (int)result * sign;
            }
        }

        return (int)result * sign;
    }
}