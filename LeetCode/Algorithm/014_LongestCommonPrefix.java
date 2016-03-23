/*

Write a function to find the longest common prefix string amongst an array of strings.

*/

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs.length == 0) {
            return "";
        }
        Arrays.sort(strs);
        
        String first = strs[0];
        if (first.equals("")) {
            return "";
        }
        String last = strs[strs.length - 1];
        
        int length = Math.min(first.length(), last.length());
        StringBuilder sb = new StringBuilder();
        
        for (int i = 0; i < length; i++) {
            if (first.charAt(i) == last.charAt(i)) {
                sb.append(first.charAt(i));
            } else {
                break;
            }
        }
        
        return sb.toString();
    }
}