/*

Given a string containing just the characters '(', ')', '{', '}', '[' and ']', determine if the input string is valid.

The brackets must close in the correct order, "()" and "()[]{}" are all valid but "(]" and "([)]" are not.

*/

public class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<Character>();
        
        for (int i = 0; i < s.length(); i++) {
            char temp = s.charAt(i);
            
            if (temp == '(' || temp == '[' || temp == '{') {
                stack.push(temp);
            } else {
                if (temp == ')') {
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (temp == ']') {
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else if (temp == '}') {
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        return false;
                    }
                } else {
                    continue;
                }
            }
        }
        
        if (stack.empty()) {
            return true;
        } else {
            return false;
        }
    }
}