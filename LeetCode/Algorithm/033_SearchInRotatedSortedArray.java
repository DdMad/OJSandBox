/*

Suppose a sorted array is rotated at some pivot unknown to you beforehand.

(i.e., 0 1 2 4 5 6 7 might become 4 5 6 7 0 1 2).

You are given a target value to search. If found in the array return its index, otherwise return -1.

You may assume no duplicate exists in the array.

*/

public class Solution {
    public int search(int[] nums, int target) {
        return searchRotatedArray(nums, target, 0, nums.length - 1);
    }
    
    public int searchRotatedArray(int[] nums, int target, int start, int end) {
        if (start > end) {
            return -1;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return mid;
        }
        
        if (nums[mid] < nums[end]) {
            // Right hand side is sorted
            if (target > nums[mid] && target <= nums[end]) {
                return searchRotatedArray(nums, target, mid + 1, end);
            } else {
                return searchRotatedArray(nums, target, start, mid - 1);
            }
        } else {
            // Left hand side is sorted
            if (target >= nums[start] && target < nums[mid]) {
                return searchRotatedArray(nums, target, start, mid - 1);
            } else {
                return searchRotatedArray(nums, target, mid + 1, end);
            }
        }
    }
}