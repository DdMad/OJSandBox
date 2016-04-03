/*

Determine if a Sudoku is valid, according to: Sudoku Puzzles - The Rules.

The Sudoku board could be partially filled, where empty cells are filled with the character '.'.


A partially filled sudoku which is valid.

Note:
A valid Sudoku board (partially filled) is not necessarily solvable. Only the filled cells need to be validated.

*/

public class Solution {
    public boolean isValidSudoku(char[][] board) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                //System.out.println("i: " + i);
                //System.out.println("j: " + j);
                //System.out.println("board: " + board[i][j]);
                if (board[i][j] != '.') {
                    // row
                    for (int k = 0; k < 9; k++) {
                        if (k != j && board[i][k] == board[i][j]) {
                            return false;
                        }
                    }
                    //System.out.println("Row true");
                    
                    // col
                    for (int k = 0; k < 9; k++) {
                        if (k != i && board[k][j] == board[i][j]) {
                            return false;
                        }
                    }
                    //System.out.println("Col true");
                    
                    // square
                    for (int k = i / 3 * 3; k < i / 3 * 3 + 3; k++) {
                        for (int m = j / 3 * 3; m < j / 3 * 3 + 3; m++) {
                            if (board[k][m] == board[i][j]) {
                                if (i == k && j == m) {
                                    continue;
                                } else {
                                    return false;
                                }
                            }
                        }
                    }
                    //System.out.println("Square true");
                }
            }
        }
        
        return true;
    }
}