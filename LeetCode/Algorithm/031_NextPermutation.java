/*

Implement next permutation, which rearranges numbers into the lexicographically next greater permutation of numbers.

If such arrangement is not possible, it must rearrange it as the lowest possible order (ie, sorted in ascending order).

The replacement must be in-place, do not allocate extra memory.

Here are some examples. Inputs are in the left-hand column and its corresponding outputs are in the right-hand column.
1,2,3 → 1,3,2
3,2,1 → 1,2,3
1,1,5 → 1,5,1

*/

public class Solution {
    public void nextPermutation(int[] nums) {
        if (nums.length < 2) {
            return;
        }
        
        int len = nums.length;
        
        for (int i = len - 2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                int index = i + 1;
                while (index < len && nums[i] < nums[index]) {
                    index++;
                }
                swap(nums, i, index - 1);
                
                for (int j = i + 1; j <= (i + len) / 2; j++) {
                    swap(nums, j, len - j + i);
                }
                
                return;
            }
        }
        
        // nums is the last permutation, just reverse it
        for (int i = 0; i < len / 2; i++) {
            swap(nums, i, len - i - 1);
        }
    }
    
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
}