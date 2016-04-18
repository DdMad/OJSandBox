/*

Given an integer n, generate a square matrix filled with elements from 1 to n2 in spiral order.

For example,
Given n = 3,

You should return the following matrix:
[
 [ 1, 2, 3 ],
 [ 8, 9, 4 ],
 [ 7, 6, 5 ]
]

*/

public class Solution {
    public int[][] generateMatrix(int n) {
        if (n <= 0) {
            return new int[0][0];
        }
        
        int[][] result = new int[n][n];
        writeSpiral(0, n - 1, 0, n - 1, result);
        return result;
    }
    
    public void writeSpiral(int up, int down, int left, int right, int[][] result) {
        int count = 1;
        while (up <= down && left <= right) {
            if (up == down) {
                for (int i = left; i <= right; i++) {
                    result[up][i] = count++;
                }
                return;
            }
            if (left == right) {
                for (int i = up; i <= down; i++) {
                    result[i][right] = count++;
                }
                return;
            }
            
            for (int i = left; i <= right; i++) {
                result[up][i] = count++;
            }
            for (int i = up + 1; i < down; i++) {
                result[i][right] = count++;
            }
            for (int i = right; i >= left; i--) {
                result[down][i] = count++;
            }
            for (int i = down - 1; i > up; i--) {
                result[i][left] = count++;
            }
            
            up++;
            down--;
            left++;
            right--;
        }
    }
}