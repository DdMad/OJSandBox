/*

Validate if a given string is numeric.

Some examples:
"0" => true
" 0.1 " => true
"abc" => false
"1 a" => false
"2e10" => true
Note: It is intended for the problem statement to be ambiguous. You should gather all requirements up front before implementing one.

Update (2015-02-10):
The signature of the C++ function had been updated. If you still see your function signature accepts a const char * argument, please click the reload button  to reset your code definition.

*/

public class Solution {
    public boolean isNumber(String s) {
        s = s.trim();
        if (s == null || s.length() == 0) {
            return false;
        }
        
        // .2 true
        // 2. true
        // 2.2e2 true
        // 2e2.2 false
        // 2e false
        // e2 false
        // .e2 false
        // e.2 false
        // 2e2e2 false
        // 2.2.2 false
        boolean hasSign = false;
        boolean hasDot = false;
        boolean validDot = true;
        boolean hasE = false;
        boolean validE = true;
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            if (temp == '-' || temp == '+') {
                // + and - can be the first char
                if (i == 0) {
                    // Sign before e
                    hasSign = true;
                    continue;
                } else if (s.charAt(i - 1) == 'e') {
                    // Sign after e
                    continue;
                } else {
                    return false;
                }
            } else if (temp >= '0' && temp <= '9') {
                validDot = true;
                if (hasE && !validE) {
                    validE = true;
                }
                continue;
            } else if (temp == '.' && !hasDot && !hasE) {
                // No dulplicate .
                hasDot = true;
                // For cases: 1. -> true; 1.11 -> true; . -> false; .e -> false;
                if (i == 0 || (hasSign && i == 1)) {
                    validDot = false;
                }
            } else if (temp == 'e' && !hasE) {
                // No dulplicate e
                if (!hasDot) {
                    // For cases: e2 -> false; 2e2 -> true; *e2 -> false;
                    if (i != 0 && s.charAt(i - 1) >= '0' && s.charAt(i - 1) <= '9') {
                        hasE = true;
                        validE = false;
                    } else {
                        return false;
                    }
                } else {
                    // For cases: .e2 -> false; 2.e2 -> true; .2e2 -> true;
                    if (validDot) {
                        hasE = true;
                        validE = false;
                    } else {
                        return false;
                    }
                }
            } else {
                return false;
            }
        }
        
        return validDot && validE;
    }
}