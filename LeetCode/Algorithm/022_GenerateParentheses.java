/*

Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.

For example, given n = 3, a solution set is:

"((()))", "(()())", "(())()", "()(())", "()()()"

*/

public class Solution {
    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList<String>();
        if (n > 0) {
            getCombinations(0, 0, n, new StringBuilder(), result);
        }
        
        return result;
    }
    
    public void getCombinations(int lCount, int rCount, int n, StringBuilder currentComb, List<String> result) {
        if (lCount == n && rCount == n) {
            result.add(currentComb.toString());
            return;
        }
        
        if (lCount < n) {
            lCount++;
            currentComb.append('(');
            getCombinations(lCount, rCount, n, currentComb, result);
            currentComb.deleteCharAt(currentComb.length() - 1);
            lCount--;
        }
        
        if (rCount < lCount) {
            rCount++;
            currentComb.append(')');
            getCombinations(lCount, rCount, n, currentComb, result);
            currentComb.deleteCharAt(currentComb.length() - 1);
            rCount--;
        }
    }
}