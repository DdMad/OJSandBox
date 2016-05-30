/*

Given a string containing only digits, restore it by returning all possible valid IP address combinations.

For example:
Given "25525511135",

return ["255.255.11.135", "255.255.111.35"]. (Order does not matter)

*/

public class Solution {
    public List<String> restoreIpAddresses(String s) {
        List<String> result = new ArrayList<String>();
        if (s == null || s.length() < 4) {
            return result;
        }
        findIPAddresses(s, 0, new ArrayList<String>(), result);
        return result;
    }
    
    public void findIPAddresses(String s, int start, List<String> current, List<String> result) {
        // If 4 parts are all found and no char is left in s
        // Add valid solution
        if (current.size() == 4) {
            if (start == s.length()) {
                result.add(createIPAddressString(current));
            }
            return;
        }
        
        // If 3 parts have been found and the length of the rest is >3 or <= 0
        // Which means invalid
        if (current.size() == 3 && (s.length() - start > 3 || s.length() - start <= 0)) {
            return;
        }
        
        StringBuilder sb = new StringBuilder();
        for (int i = start; i < start + 3; i++) {
            if (i < s.length()) {
                sb.append(s.charAt(i));
                if (i == start) {
                    // One-char integer, can be 0
                    current.add(sb.toString());
                    findIPAddresses(s, i + 1, current, result);
                } else {
                    // Two-char or three-char integer, first cannot be 0
                    if (s.charAt(start) != '0') {
                        if (i == start + 1) {
                            // Two-char integer can be 10-99
                            current.add(sb.toString());
                            findIPAddresses(s, i + 1, current, result);
                        } else {
                            // Three-char integer can only be 100-255
                            if (s.charAt(start) == '1' || (s.charAt(start) == '2' && s.charAt(start + 1) < '5') ||
                            (s.charAt(start) == '2' && s.charAt(start + 1) == '5' && s.charAt(start + 2) <= '5')) {
                                current.add(sb.toString());
                                findIPAddresses(s, i + 1, current, result);
                            } else {
                                return;
                            }
                        }
                    } else {
                        return;
                    }
                }
            } else {
                return;
            }
            // Backtracing
            current.remove(current.size() - 1);
        }
    }
    
    public String createIPAddressString(List<String> current) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < current.size() - 1; i++) {
            sb.append(current.get(i));
            sb.append('.');
        }
        sb.append(current.get(current.size() - 1));
        return sb.toString();
    }
}