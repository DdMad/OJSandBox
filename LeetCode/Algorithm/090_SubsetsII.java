/*

Given a collection of integers that might contain duplicates, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,2], a solution is:

[
  [2],
  [1],
  [1,2,2],
  [2,2],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        result.add(new ArrayList<Integer>());
        findSubset(nums, 0, result, new ArrayList<Integer>());
        return result;
    }
    
    public void findSubset(int[] nums, int start, List<List<Integer>> result, List<Integer> current) {
        if (start >= nums.length) {
            return;
        }
        for (int i = start; i < nums.length; i++) {
            current.add(nums[i]);
            result.add(new ArrayList<Integer>(current));
            findSubset(nums, i + 1, result, current);
            current.remove(current.size() - 1);
            
            // Remove dulplicate paths
            while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                i++;
            }
        }
    }
}