/*

Given a sorted array and a target value, return the index if the target is found. If not, return the index where it would be if it were inserted in order.

You may assume no duplicates in the array.

Here are few examples.
[1,3,5,6], 5 → 2
[1,3,5,6], 2 → 1
[1,3,5,6], 7 → 4
[1,3,5,6], 0 → 0

*/

public class Solution {
    public int searchInsert(int[] nums, int target) {
        int len = nums.length;
        int start = 0;
        int end = len - 1;
        
        if (len == 0) {
            return 0;
        }
        
        if (len == 1) {
            return nums[0] < target ? 1 : 0;
        }
        
        while(start < end) {
            int mid = (start + end) / 2;
            
            if (nums[mid] == target) {
                return mid;
            } else if (nums[mid] < target) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        
        if (nums[start] < target) {
            return start + 1;
        } else {
            return start;
        }
    }
}