/*

Given an array of integers, every element appears twice except for one. Find that single one.

Note:
Your algorithm should have a linear runtime complexity. Could you implement it without using extra memory?

*/

public class Solution {
    public int singleNumber(int[] nums) {
        if (nums == null) {
            return 0;
        }
        
        // x^x = 0
        // x^0 = x
        // x^y^z = y^z^x = y^x^z = ...
        int result = 0;
        for (int i = 0; i < nums.length; i++) {
            result ^= nums[i];
        }
        
        return result;
    }
}