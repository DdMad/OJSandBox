/*

Write a program to solve a Sudoku puzzle by filling the empty cells.

Empty cells are indicated by the character '.'.

You may assume that there will be only one unique solution.

*/

public class Solution {
    public void solveSudoku(char[][] board) {
        if (board == null || board.length != 9 || board[0].length != 9) {
            return;
        }
        
        solve(board, 0, 0);
    }
    
    public boolean solve(char[][] board, int r, int c) {
        if (c >= 9) {
            r += 1;
            c = 0;
        }
        
        if (r >= 9) {
            return true;
        }
        
        if (board[r][c] == '.') {
            for (int i = 1; i <= 9; i++) {
                board[r][c] = (char)(i + '0');
                if (isValid(board, r, c)) {
                    if (solve(board, r, c + 1)) {
                        return true;
                    }
                }
                board[r][c] = '.';
            }
        } else {
            return solve(board, r, c + 1);
        }
        
        return false;
    }
    
    public boolean isValid(char[][] board, int r, int c) {
        // row
        for (int i = 0; i < 9; i++) {
            if (i != c && board[r][i] == board[r][c]) {
                return false;
            }
        }
        
        // col
        for (int i = 0; i < 9; i++) {
            if (i != r && board[i][c] == board[r][c]) {
                return false;
            }
        }
        
        // square
        for (int i = r / 3 * 3; i < r / 3 * 3 + 3; i++) {
            for (int j = c / 3 * 3; j < c / 3 * 3 + 3; j++) {
                if ((i != r || j != c) && board[i][j] == board[r][c]) {
                    return false;
                }
            }
        }
        
        return true;
    }
}