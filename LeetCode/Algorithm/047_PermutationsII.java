/*

Given a collection of numbers that might contain duplicates, return all possible unique permutations.

For example,
[1,1,2] have the following unique permutations:
[1,1,2], [1,2,1], and [2,1,1].

*/

public class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        Arrays.sort(nums);
        backTracking(nums, 0, new HashSet<Integer>(), new Stack<Integer>(), result);
        return result;
    }
    
    public void backTracking(int[] nums, int index, Set<Integer> used, Stack<Integer> current, List<List<Integer>> result) {
        if (index >= nums.length) {
            result.add(new ArrayList<Integer>((List<Integer>)current));
            return;
        }
        
        for (int i = 0; i < nums.length; i++) {
            if (!used.contains(i)) {
                used.add(i);
                current.push(nums[i]);
                backTracking(nums, index + 1, used, current, result);
                current.pop();
                used.remove(i);
                while (i < nums.length - 1 && nums[i] == nums[i + 1]) {
                    i++;
                }
            }
        }
    }
}