/*

Given an array with n objects colored red, white or blue, sort them so that objects of the same color are adjacent, with the colors in the order red, white and blue.

Here, we will use the integers 0, 1, and 2 to represent the color red, white, and blue respectively.

Note:
You are not suppose to use the library's sort function for this problem.

click to show follow up.

Follow up:
A rather straight forward solution is a two-pass algorithm using counting sort.
First, iterate the array counting number of 0's, 1's, and 2's, then overwrite array with total number of 0's, then 1's and followed by 2's.

Could you come up with an one-pass algorithm using only constant space?

*/

public class Solution {
    public void sortColors(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        
        int len = nums.length;
        int front = 0;
        int end = len - 1;
        
        int i = 0;
        while (i <= end) {
            if (nums[i] == 0) {
                swap(nums, front, i);
                i++; // Since after exchange, the new nums[i] we have checked before, so i++
                front++;
            } else if (nums[i] == 2) {
                swap(nums, end, i);
                // Since after exchange, the new nums[i] we haven't checked
                // So need to check again nums[i]
                end--;
            } else {
                i++;
            }
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}