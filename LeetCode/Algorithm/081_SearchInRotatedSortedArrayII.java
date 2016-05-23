/*

Follow up for "Search in Rotated Sorted Array":
What if duplicates are allowed?

Would this affect the run-time complexity? How and why?

Write a function to determine if a given target is in the array.

*/

public class Solution {
    public boolean search(int[] nums, int target) {
        return searchRotatedSortedArray(nums, target, 0, nums.length - 1);
    }
    
    public boolean searchRotatedSortedArray(int[] nums, int target, int start, int end) {
        if (start > end) {
            return false;
        }
        
        int mid = (start + end) / 2;
        if (nums[mid] == target) {
            return true;
        }
        
        if (nums[mid] < nums[end]) {
            // Right hand side is sorted
            if (target > nums[mid] && target <= nums[end]) {
                return searchRotatedSortedArray(nums, target, mid + 1, end);
            } else {
                return searchRotatedSortedArray(nums, target, start, mid - 1);
            }
        } else if (nums[mid] == nums[end]) {
            // Just remove the last one and search again
            // Worst case: O(n), which means all numbers are the same
            return searchRotatedSortedArray(nums, target, start, end - 1);
        } else {
            // Left hand side is sorted
            if (target >= nums[start] && target < nums[mid]) {
                return searchRotatedSortedArray(nums, target, start, mid - 1);
            } else {
                return searchRotatedSortedArray(nums, target, mid + 1, end);
            }
        }
    }
}