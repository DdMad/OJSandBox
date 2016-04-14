/*

You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

Follow up:
Could you do this in-place?

*/

public class Solution {
    public void rotate(int[][] matrix) {
        rotateSquare(0, matrix[0].length, matrix[0].length, matrix);
    }
    
    public void rotateSquare(int x, int len, int n, int[][] matrix) {
        if (n <= 1) {
            return;
        }
        
        // matrix[x][y] is top-left corner
        for (int i = 0; i < n - 1; i++) {
            int temp1 = matrix[x + i][len - x - 1];
            matrix[x + i][len - x - 1] = matrix[x][x + i];
            int temp2 = matrix[len - x - 1][len - x - i - 1];
            matrix[len - x - 1][len - x - i - 1] = temp1;
            temp1 = temp2;
            temp2 = matrix[len - x - i - 1][x];
            matrix[len - x - i - 1][x] = temp1;
            matrix[x][x + i] = temp2;
        }
        
        rotateSquare(x + 1, len, n - 2, matrix);
    }
}