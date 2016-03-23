/*

Given n non-negative integers a1, a2, ..., an, where each represents a point at coordinate (i, ai). n vertical lines are drawn such that the two endpoints of line i is at (i, ai) and (i, 0). Find two lines, which together with x-axis forms a container, such that the container contains the most water.

Note: You may not slant the container.

*/

public class Solution {
    public int maxArea(int[] height) {
        if (height.length < 2) {
            return 0;
        }
        
        int max = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            int area = calcArea(height, left, right);
            max = max < area ? area : max;
            
            if (height[left] > height[right]) {
                right--;
            } else if (height[left] == height[right]) {
                left++;
                right--;
            } else {
                left++;
            }
        }
        
        return max;
    }
    
    public int calcArea(int[] height, int left, int right) {
        if (height[left] < height[right]) {
            return (right - left) * height[left];
        } else {
            return (right - left) * height[right];
        }
    }
}