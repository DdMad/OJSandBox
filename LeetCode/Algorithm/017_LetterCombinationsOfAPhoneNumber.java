/*

Given a digit string, return all possible letter combinations that the number could represent.

A mapping of digit to letters (just like on the telephone buttons) is given below.



Input:Digit string "23"
Output: ["ad", "ae", "af", "bd", "be", "bf", "cd", "ce", "cf"].
Note:
Although the above answer is in lexicographical order, your answer could be in any order you want.

*/

public class Solution {
    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<String>();
        getCombinations(digits, new StringBuilder(), 0, result);
        
        return result;
    }
    
    public void getCombinations(String digits, StringBuilder current, int index, List<String> result) {
        String[] map = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        
        if (index >= digits.length()) {
            if (current.length() != 0) {
                result.add(current.toString());
            }
        } else {
            int currentInt = digits.charAt(index) - '0';
            
            index++;
            if (currentInt >= 2 && currentInt <= 9) {
                for (int i = 0; i < map[currentInt].length(); i++) {
                    current.append(map[currentInt].charAt(i));
                    getCombinations(digits, current, index, result);
                    current.deleteCharAt(current.length() - 1);
                }
            } else {
                getCombinations(digits, current, index, result);
            }
        }
    }
}