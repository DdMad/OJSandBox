/*

Given an array of words and a length L, format the text such that each line has exactly L characters and is fully (left and right) justified.

You should pack your words in a greedy approach; that is, pack as many words as you can in each line. Pad extra spaces ' ' when necessary so that each line has exactly L characters.

Extra spaces between words should be distributed as evenly as possible. If the number of spaces on a line do not divide evenly between words, the empty slots on the left will be assigned more spaces than the slots on the right.

For the last line of text, it should be left justified and no extra space is inserted between words.

For example,
words: ["This", "is", "an", "example", "of", "text", "justification."]
L: 16.

Return the formatted lines as:
[
   "This    is    an",
   "example  of text",
   "justification.  "
]
Note: Each word is guaranteed not to exceed L in length.

click to show corner cases.

Corner Cases:
A line other than the last line might contain only one word. What should you do in this case?
In this case, that line should be left-justified.

*/

public class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<String>();
        if (words == null || words.length == 0) {
            return result;
        }
        
        int i = 0;
        while (i < words.length) {
            int count = 1;
            int len = words[i].length();
            int start = i++;
            
            while (i < words.length && len + words[i].length() + 1 <= maxWidth) {
                len += words[i].length() + 1;
                count++;
                i++;
            }
            
            if (count == 1) {
                StringBuilder sb = new StringBuilder(words[start]);
                for (int j = 0; j < maxWidth - words[start].length(); j++) {
                    sb.append(' ');
                }
                result.add(sb.toString());
            } else if (i >= words.length) {
                StringBuilder sb = new StringBuilder(words[start]);
                for (int j = start + 1; j < i; j++) {
                    sb.append(' ');
                    sb.append(words[j]);
                }
                int temp = sb.length();
                for (int j = 0; j < maxWidth - temp; j++) {
                    sb.append(' ');
                }
                result.add(sb.toString());
            } else {
                StringBuilder sb = new StringBuilder();
                int spaces = (maxWidth - len) / (count - 1);
                int moreSpaceAmount = maxWidth - len - spaces * (count - 1);
                for (int j = start; j < start + count - 1; j++) {
                    sb.append(words[j]);
                    sb.append(' ');
                    for (int k = 0; k < spaces; k++) {
                        sb.append(' ');
                    }
                    if (moreSpaceAmount > 0) {
                        sb.append(' ');
                        moreSpaceAmount--;
                    }
                }
                sb.append(words[start + count - 1]);
                result.add(sb.toString());
            }
        }
        
        return result;
    }
}