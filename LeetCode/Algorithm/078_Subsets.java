/*

Given a set of distinct integers, nums, return all possible subsets.

Note:
Elements in a subset must be in non-descending order.
The solution set must not contain duplicate subsets.
For example,
If nums = [1,2,3], a solution is:

[
  [3],
  [1],
  [2],
  [1,2,3],
  [1,3],
  [2,3],
  [1,2],
  []
]

*/

public class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        Arrays.sort(nums);
        search(nums, 0, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void search(int[] nums, int index, List<Integer> current, List<List<Integer>> result) {
        result.add(new ArrayList<Integer>(current));
        
        for (int i = index; i < nums.length; i++) {
            current.add(nums[i]);
            search(nums, i + 1, current, result);
            current.remove(current.size() - 1);
        }
    }
}