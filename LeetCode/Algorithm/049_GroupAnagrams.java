/*

Given an array of strings, group anagrams together.

For example, given: ["eat", "tea", "tan", "ate", "nat", "bat"], 
Return:

[
  ["ate", "eat","tea"],
  ["nat","tan"],
  ["bat"]
]
Note:
For the return value, each inner list's elements must follow the lexicographic order.
All inputs will be in lower-case.

*/

public class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (strs == null || strs.length == 0) {
            return result;
        }
        
        HashMap<String, List<String>> map = new HashMap<String, List<String>>();
        Arrays.sort(strs);
        for (int i = 0; i < strs.length; i++) {
            char[] temp = strs[i].toCharArray();
            Arrays.sort(temp);
            String newString = new String(temp);
            if (map.get(newString) == null) {
                List<String> list = new ArrayList<String>();
                list.add(strs[i]);
                map.put(newString, list);
            } else {
                map.get(newString).add(strs[i]);
            }
        }
        
        for (List<String> list : map.values()) {
            result.add(list);
        }
        
        return result;
    }
}