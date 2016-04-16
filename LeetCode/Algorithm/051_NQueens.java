/*

The n-queens puzzle is the problem of placing n queens on an n×n chessboard such that no two queens attack each other.



Given an integer n, return all distinct solutions to the n-queens puzzle.

Each solution contains a distinct board configuration of the n-queens' placement, where 'Q' and '.' both indicate a queen and an empty space respectively.

For example,
There exist two distinct solutions to the 4-queens puzzle:

[
 [".Q..",  // Solution 1
  "...Q",
  "Q...",
  "..Q."],

 ["..Q.",  // Solution 2
  "Q...",
  "...Q",
  ".Q.."]
]

*/

public class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> result = new ArrayList<List<String>>();
        if (n <= 0) {
            return result;
        }
        int[] used = new int[n];
        solve(n, 0, used, result);
        return result;
    }
    
    public void solve(int n, int row, int[] used, List<List<String>> result) {
        if (row == n) {
            List<String> temp = new ArrayList<String>();
            for (int i = 0; i < n; i++) {
                temp.add(buildRow(n, used[i]));
            }
            result.add(temp);
            return;
        }
        for (int i = 0; i < n; i++) {
            if (isValid(used, row, i)) {
                used[row] = i;
                solve(n, row + 1, used, result);
            }
        }
    }
    
    public boolean isValid(int[] used, int row, int index) {
        // Not in the same row, same column, and same diagonal
        for (int i = 0; i < row; i++) {
            if (used[i] != index && Math.abs(i - row) != Math.abs(used[i] - index)) {
                continue;
            } else {
                return false;
            }
        }
        return true;
    }
    
    public String buildRow(int n, int queenIndex) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            if (i == queenIndex) {
                sb.append('Q');
            } else {
                sb.append('.');
            }
        }
        return sb.toString();
    }
}