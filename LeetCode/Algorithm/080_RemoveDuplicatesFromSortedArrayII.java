/*

Follow up for "Remove Duplicates":
What if duplicates are allowed at most twice?

For example,
Given sorted array nums = [1,1,1,2,2,3],

Your function should return length = 5, with the first five elements of nums being 1, 1, 2, 2 and 3. It doesn't matter what you leave beyond the new length.

*/

public class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        
        int current = 0;
        boolean twice = false;
        for (int i = 0; i < nums.length; i++) {
            if (i == 0 || nums[i] != nums[current - 1]) {
                // Insert the needed number into the current position
                nums[current] = nums[i];
                twice = false;
                current++;
            } else {
                // Check if the amount of duplicate is more than 2
                if (!twice) {
                    nums[current] = nums[i];
                    twice = true;
                    current++;
                } else {
                    // Jump over the duplicate that more than 2
                    while (i < nums.length && nums[i] == nums[i - 1]) {
                        i++;
                    }
                    if (i < nums.length) {
                        nums[current] = nums[i];
                        current++;
                        twice = false;
                    }
                }
            }
        }
        
        return current;
    }
}