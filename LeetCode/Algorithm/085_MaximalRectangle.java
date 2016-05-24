/*

Given a 2D binary matrix filled with 0's and 1's, find the largest rectangle containing all ones and return its area.

*/

public class Solution {
    public int maximalRectangle(char[][] matrix) {
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }
        
        int max = 0;
        int[] heights = new int[matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            // Update heights of each row
            for (int j = 0; j < matrix[0].length; j++) {
                if (matrix[i][j] == '1') {
                    heights[j] += 1;
                } else {
                    heights[j] = 0;
                }
            }
            
            // Then calculate maximum rectangle among all largest rectangles of rows
            int temp = largestRectangleArea(heights);
            max = temp > max ? temp : max;
        }
        
        return max;
    }
    
    // Copy from 084
    public int largestRectangleArea(int[] heights) {
        int maxArea = 0;
        if (heights == null || heights.length == 0) {
            return maxArea;
        }
        
        Stack<Integer> stack = new Stack<Integer>();
        int i = 0;
        while (i < heights.length) {
            if (stack.isEmpty() || heights[stack.peek()] <= heights[i]) {
                stack.push(i++);
            } else {
                int temp = stack.peek();
                stack.pop();
                
                int tempArea = heights[temp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
                maxArea = tempArea > maxArea ? tempArea : maxArea;
            }
        }
        
        while (!stack.isEmpty()) {
            int temp = stack.peek();
            stack.pop();
            
            int tempArea = heights[temp] * (stack.isEmpty() ? i : i - stack.peek() - 1);
            maxArea = tempArea > maxArea ? tempArea : maxArea;
        }
        
        return maxArea;
    }
}