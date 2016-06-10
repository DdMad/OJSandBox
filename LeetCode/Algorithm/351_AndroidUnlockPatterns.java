/*

Given an Android 3x3 key lock screen and two integers m and n, where 1 ≤ m ≤ n ≤ 9, count the total number of unlock patterns of the Android lock screen, which consist of minimum of m keys and maximum n keys.

Rules for a valid pattern:
Each pattern must connect at least m keys and at most n keys.
All the keys must be distinct.
If the line connecting two consecutive keys in the pattern passes through any other keys, the other keys must have previously selected in the pattern. No jumps through non selected key is allowed.
The order of keys used matters.

Explanation:
| 1 | 2 | 3 |
| 4 | 5 | 6 |
| 7 | 8 | 9 |
Invalid move: 4 - 1 - 3 - 6 
Line 1 - 3 passes through key 2 which had not been selected in the pattern.

Invalid move: 4 - 1 - 9 - 2
Line 1 - 9 passes through key 5 which had not been selected in the pattern.

Valid move: 2 - 4 - 1 - 3 - 6
Line 1 - 3 is valid because it passes through key 2, which had been selected in the pattern

Valid move: 6 - 5 - 4 - 1 - 9 - 2
Line 1 - 9 is valid because it passes through key 5, which had been selected in the pattern.

Example:
Given m = 1, n = 1, return 9.

Credits:
Special thanks to @elmirap for adding this problem and creating all test cases.

*/

public class Solution {
    public int numberOfPatterns(int m, int n) {
        int[][] rules = new int[10][10];
        
        // Can use some elegant way to define the rules
        // Here we just define it one by one:
        // if rules[i][j] = 0, means connection between i and j does not pass any other key
        // else it passes value of rules[i][j]
        rules[1][9] = 5;
        rules[9][1] = 5;
        rules[3][7] = 5;
        rules[7][3] = 5;
        
        rules[1][7] = 4;
        rules[7][1] = 4;
        rules[2][8] = 5;
        rules[8][2] = 5;
        rules[3][9] = 6;
        rules[9][3] = 6;
        
        rules[1][3] = 2;
        rules[3][1] = 2;
        rules[4][6] = 5;
        rules[6][4] = 5;
        rules[7][9] = 8;
        rules[9][7] = 8;
        
        List<Integer> result = new ArrayList<Integer>();
        result.add(0);
        findPatterns(m, n, 0, new HashSet<Integer>(), result, rules);
        return result.get(0);
    }
    
    public void findPatterns(int m, int n, int last, HashSet<Integer> visited, List<Integer> result, int[][] rules) {
        if (visited.size() > n) {
            return;
        }
        
        if (visited.size() >= m && visited.size() <= n) {
            result.set(0, result.get(0) + 1);
        }
        
        for (int i = 1; i <= 9; i++) {
            if (!visited.contains(i)) {
                // 1. It is the first key
                // 2. Connection with last key not go through other key
                // 3. Connection with last key go through some key that already visit
                if (last == 0 || rules[last][i] == 0 || visited.contains(rules[last][i])) {
                    visited.add(i);
                    findPatterns(m, n, i, visited, result, rules);
                    visited.remove(i);
                }
            }
        }
    }
}