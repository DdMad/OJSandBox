/*

Given n non-negative integers representing the histogram's bar height where the width of each bar is 1, find the area of largest rectangle in the histogram.


Above is a histogram where width of each bar is 1, given height = [2,1,5,6,2,3].


The largest rectangle is shown in the shaded area, which has area = 10 unit.

For example,
Given heights = [2,1,5,6,2,3],
return 10.

*/

public class Solution {
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