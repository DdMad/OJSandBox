/*

Write an efficient algorithm that searches for a value in an m x n matrix. This matrix has the following properties:

Integers in each row are sorted from left to right.
The first integer of each row is greater than the last integer of the previous row.
For example,

Consider the following matrix:

[
  [1,   3,  5,  7],
  [10, 11, 16, 20],
  [23, 30, 34, 50]
]
Given target = 3, return true.

*/

public class Solution {
    public boolean searchMatrix(int[][] matrix, int target) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }
        
        int start = 0;
        int end = matrix.length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (matrix[mid][0] > target) {
                end = mid - 1;
            } else if (matrix[mid][0] < target) {
                if (matrix[mid][matrix[0].length - 1] > target) {
                    start = mid;
                    break;
                } else if (matrix[mid][matrix[0].length - 1] < target) {
                    start = mid + 1;
                } else {
                    return true;
                }
            } else {
                return true;
            }
        }
        
        int row = start;
        start = 0;
        end = matrix[row].length - 1;
        while (start < end) {
            int mid = (start + end) / 2;
            if (matrix[row][mid] > target) {
                end = mid - 1;
            } else if (matrix[row][mid] < target) {
                start = mid + 1;
            } else {
                return true;
            }
        }

        return matrix[row][start] == target ? true : false;
    }
}