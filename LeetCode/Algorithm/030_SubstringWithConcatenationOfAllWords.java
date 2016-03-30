/*

You are given a string, s, and a list of words, words, that are all of the same length. Find all starting indices of substring(s) in s that is a concatenation of each word in words exactly once and without any intervening characters.

For example, given:
s: "barfoothefoobarman"
words: ["foo", "bar"]

You should return the indices: [0,9].
(order does not matter).

*/

public class Solution {
    public List<Integer> findSubstring(String s, String[] words) {
        List<Integer> result = new ArrayList<Integer>();
        HashMap<String, Integer> wordMap = new HashMap<String, Integer>();
        if (words.length == 0) {
            return result;
        }
        
        int totalLength = 0;
        int wordLength = words[0].length();
        int wordCount = words.length;
        int stringLength = s.length();
        
        for (int i = 0; i < wordCount; i++) {
            totalLength += words[i].length();
            
            if (wordMap.containsKey(words[i])) {
                wordMap.put(words[i], wordMap.get(words[i]) + 1);
            } else {
                wordMap.put(words[i], 1);
            }
        }
        
        if (stringLength < totalLength) {
            return result;
        }
        
        for (int i = 0; i <= stringLength - totalLength; i++) {
            if (isSubstring(s, i, wordMap, wordCount, wordLength)) {
                result.add(i);
            }
        }
        
        return result;
    }
    
    public boolean isSubstring(String s, int index, HashMap<String, Integer> wordMap, int wordCount, int wordLength) {
        HashMap<String, Integer> count = new HashMap<String, Integer>(wordMap);

        for (int i = 0; i < wordCount; i++) {
            String temp = s.substring(index, index + wordLength);
            
            if (!count.containsKey(temp)) {
                return false;
            } else {
                if (count.get(temp) == 1) {
                    count.remove(temp);
                } else {
                    count.put(temp, count.get(temp) - 1);
                }
            }
            
            index += wordLength;
        }
        
        return count.isEmpty();
    }
}