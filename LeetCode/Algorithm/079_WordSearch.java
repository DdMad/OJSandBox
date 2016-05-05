/*

Given a 2D board and a word, find if the word exists in the grid.

The word can be constructed from letters of sequentially adjacent cell, where "adjacent" cells are those horizontally or vertically neighboring. The same letter cell may not be used more than once.

For example,
Given board =

[
  ['A','B','C','E'],
  ['S','F','C','S'],
  ['A','D','E','E']
]
word = "ABCCED", -> returns true,
word = "SEE", -> returns true,
word = "ABCB", -> returns false.

*/

public class Solution {
    public boolean exist(char[][] board, String word) {
        if (board == null || word == null) {
            return false;
        }
        if (board.length == 0 || board[0].length == 0) {
            return false;
        }
        if (word.length() == 0) {
            return true;
        }
        
        // Here cannot create visited array inside search function
        // Otherwise, it will create new array each iteration, and it will cause TLE
        boolean[][] visited = new boolean[board.length][board[0].length];
        
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (search(board, i, j, visited, 0, word)) {
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean search(char[][] board, int row, int col, boolean[][] visited, int index, String word) {
        if (index == word.length()) {
            return true;
        }
        if (row < 0 || col < 0 || row >= board.length || col >= board[0].length ||
            visited[row][col] || word.charAt(index) != board[row][col]) {
            return false;
        }
        
        visited[row][col] = true;
        if (search(board, row - 1, col, visited, index + 1, word)) {
            return true;
        }
        if (search(board, row, col - 1, visited, index + 1, word)) {
            return true;
        }
        if (search(board, row + 1, col, visited, index + 1, word)) {
            return true;
        }
        if (search(board, row, col + 1, visited, index + 1, word)) {
            return true;
        }
        visited[row][col] = false;
        return false;
    }
}