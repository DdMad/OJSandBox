/*

Follow up for N-Queens problem.

Now, instead outputting board configurations, return the total number of distinct solutions.

*/

public class Solution {
    // Almost the same as N-Queens I
    public int totalNQueens(int n) {
        int[] result = new int[1];
        solve(n, 0, new int[n], result);
        return result[0];
    }
    
    public void solve(int n, int row, int[] used, int[] result) {
        if (row == n) {
            result[0]++;
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
}