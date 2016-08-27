/*

Given two words (beginWord and endWord), and a dictionary's word list, find the length of shortest transformation sequence from beginWord to endWord, such that:

Only one letter can be changed at a time
Each intermediate word must exist in the word list
For example,

Given:
beginWord = "hit"
endWord = "cog"
wordList = ["hot","dot","dog","lot","log"]
As one shortest transformation is "hit" -> "hot" -> "dot" -> "dog" -> "cog",
return its length 5.

Note:
Return 0 if there is no such transformation sequence.
All words have the same length.
All words contain only lowercase alphabetic characters.
Subscribe to see which companies asked this question

*/

/*

It will be faster if using two-ended BFS
More precisely, it means search from both ends and each time just search the one end that has less next-level nodes.

*/

public class Solution {
    public int ladderLength(String beginWord, String endWord, Set<String> wordList) {
        if (beginWord.length() != endWord.length() || (beginWord.equals(endWord) && wordList.isEmpty())) {
            return 0;
        }
        
        if (beginWord.equals(endWord)) {
            return 1;
        }
        
        Queue<String> queue = new LinkedList<String>();
        Set<String> used = new HashSet<String>();
        queue.offer(beginWord);
        used.add(beginWord);
        
        int level = 1;
        int currentLevelAmount = 1;
        int nextLevelAmount = 0;
        
        while(!queue.isEmpty()) {
            String currentWord = queue.poll();
            currentLevelAmount--;
            
            // Here we have two choices
            // 1st: Compare each word in the wordList to find out the words that are only 1-char different from current word
            // 2nd: Change each of the char in current word with a-z and find whether there is some same word in the word list
            // If wordList.size() > 26, then second will be better
            // Else, first solution is better
            // Here we use second one
            for (int i = 0; i < currentWord.length(); i++) {
                // This statement must put here since its time is O(w)
                // If put into the inner for loop, there will be TLE
                StringBuilder next = new StringBuilder(currentWord);
                for (char j = 'a'; j <= 'z'; j++) {
                    if (currentWord.charAt(i) != j) {
                        next.setCharAt(i, j);
                        String nextWord = next.toString();
                        
                        if (nextWord.equals(endWord)) {
                            return level + 1;
                        } else {
                            if (wordList.contains(nextWord) && !used.contains(nextWord)) {
                                queue.offer(nextWord);
                                used.add(nextWord);
                                nextLevelAmount += 1;
                            }
                        }
                    }
                }
            }
            
            if (currentLevelAmount == 0) {
                level++;
                currentLevelAmount = nextLevelAmount;
                nextLevelAmount = 0;
            }
        }
        
        return 0;
    }
}