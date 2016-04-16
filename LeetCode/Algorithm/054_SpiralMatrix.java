/*

Given a matrix of m x n elements (m rows, n columns), return all elements of the matrix in spiral order.

For example,
Given the following matrix:

[
 [ 1, 2, 3 ],
 [ 4, 5, 6 ],
 [ 7, 8, 9 ]
]
You should return [1,2,3,6,9,8,7,4,5].

*/

public class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        List<Integer> result = new ArrayList<Integer>();
        if (matrix == null || matrix.length == 0) {
            return result;
        }
        
        int m = matrix.length;
        int n = matrix[0].length;
        
        int up = 0;
        int down = m - 1;
        int left = 0;
        int right = n - 1;
        
        while (up <= down && left <= right) {
            getOneRound(up, down, left, right, matrix, result);
            up++;
            down--;
            left++;
            right--;
        }
        
        return result;
    }
    
    public void getOneRound(int up, int down, int left, int right, int[][] matrix, List<Integer> result) {
        if (up == down) {
            for (int i = left; i <= right; i++) {
                result.add(matrix[up][i]);
            }
            return;
        }
        
        if (left == right) {
            for (int i = up; i <= down; i++) {
                result.add(matrix[i][right]);
            }
            return;
        }
        
        for (int i = left; i <= right; i++) {
            result.add(matrix[up][i]);
        }
        for (int i = up + 1; i < down; i++) {
            result.add(matrix[i][right]);
        }
        for (int i = right; i >= left; i--) {
            result.add(matrix[down][i]);
        }
        for (int i = down - 1; i > up; i--) {
            result.add(matrix[i][left]);
        }
    }
}