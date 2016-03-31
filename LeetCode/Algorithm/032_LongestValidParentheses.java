/*

Given a string containing just the characters '(' and ')', find the length of the longest valid (well-formed) parentheses substring.

For "(()", the longest valid parentheses substring is "()", which has length = 2.

Another example is ")()())", where the longest valid parentheses substring is "()()", which has length = 4.

*/

public class Solution {
    
    // Can use dp
    // dp[i] represent from s[0] to s[i - 1] the longest valid parentheses, must including the s[i - 1]
    public int longestValidParentheses(String s) {
        int len = s.length();
        if (len == 0) {
            return 0;
        }
        
        Stack<Integer> intStack = new Stack<Integer>();
        Stack<Character> parStack = new Stack<Character>();
        int maxLen = 0;
        int curLen = 0;
        for (int i = 0; i < len; i++) {
            if (s.charAt(i) == '(') {
                intStack.push(i);
                parStack.push('(');
            } else {
                if (parStack.isEmpty() || parStack.peek() == ')') {
                    intStack.push(i);
                    parStack.push(')');
                } else {
                    parStack.pop();
                    intStack.pop();
                    if (parStack.isEmpty()) {
                        curLen = i + 1;
                    } else {
                        curLen = i - intStack.peek();
                    }
                    maxLen = curLen > maxLen ? curLen : maxLen;
                }
            }
        }
        
        return maxLen;
    }
}