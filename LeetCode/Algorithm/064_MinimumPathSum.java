/*

Given a m x n grid filled with non-negative numbers, find a path from top left to bottom right which minimizes the sum of all numbers along its path.

Note: You can only move either down or right at any point in time.

*/

public class Solution {
    public int minPathSum(int[][] grid) {
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return 0;
        }
        int m = grid.length;
        int n = grid[0].length;
        int[][] f = new int[m][n];
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            f[i][0] = count;
            count += grid[i][0];
        }
        
        count = 0;
        for (int i = 0; i < n; i++) {
            f[0][i] = count;
            count += grid[0][i];
        }
        
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                int up = f[i - 1][j] + grid[i - 1][j];
                int left = f[i][j - 1] + grid[i][j - 1];
                
                f[i][j] = up < left ? up : left;
            }
        }
        
        return f[m - 1][n - 1] + grid[m - 1][n - 1];
    }
}