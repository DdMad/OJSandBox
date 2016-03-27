/*

Given an array S of n integers, are there elements a, b, c, and d in S such that a + b + c + d = target? Find all unique quadruplets in the array which gives the sum of target.

Note:
Elements in a quadruplet (a,b,c,d) must be in non-descending order. (ie, a ≤ b ≤ c ≤ d)
The solution set must not contain duplicate quadruplets.
    For example, given array S = {1 0 -1 0 -2 2}, and target = 0.

    A solution set is:
    (-1,  0, 0, 1)
    (-2, -1, 1, 2)
    (-2,  0, 0, 2)

*/

public class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {
        Arrays.sort(nums);
        
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if(nums.length < 4) {
            return result;
        }
        
        for (int i = 0; i < nums.length -3; i++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }
            
            for (int j = i + 1; j < nums.length - 2; j++) {
                if (j > i + 1 && nums[j] == nums[j - 1]) {
                    continue;
                }
                
                int p = j + 1;
                int q = nums.length - 1;
                
                while (p < q) {
                    int sum = nums[i] + nums[j] + nums[p] + nums[q];
                    
                    if (sum == target) {
                        List<Integer> quadruplet = new ArrayList<Integer>();
                        quadruplet.add(nums[i]);
                        quadruplet.add(nums[j]);
                        quadruplet.add(nums[p]);
                        quadruplet.add(nums[q]);
                        result.add(quadruplet);
                        
                        while (p < q && nums[p] == nums[p + 1]) p++;
                        while (p < q && nums[q] == nums[q - 1]) q--;
                        
                        p++;
                        q--;
                    } else if (sum > target) {
                        q--;
                    } else {
                        p++;
                    }
                }
            }
        }
        
        return result;
    }
}