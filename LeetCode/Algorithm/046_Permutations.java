/*

Given a collection of distinct numbers, return all possible permutations.

For example,
[1,2,3] have the following permutations:
[1,2,3], [1,3,2], [2,1,3], [2,3,1], [3,1,2], and [3,2,1].

*/

public class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (nums == null || nums.length == 0) {
            return result;
        }
        
        // If result needs to be sorted, then sort the array first, 
        // and then insert each element from end to front.
        
        List<Integer> temp = new ArrayList<Integer>();
        temp.add(nums[0]);
        result.add(temp);
        
        for (int i = 1; i < nums.length; i++) {
            List<List<Integer>> tempResult = new ArrayList<List<Integer>>();
            
            for (List list : result) {
                int newInt = nums[i];
                List<Integer> newList;
                for (int j = 0; j < list.size(); j++) {
                    newList = new ArrayList<Integer>(list);
                    newList.add(j, newInt);
                    tempResult.add(newList);
                }
                newList = new ArrayList<Integer>(list);
                newList.add(newInt);
                tempResult.add(newList);
            }
            
            result = tempResult;
        }
        
        return result;
    }
}