/*

Given two integers n and k, return all possible combinations of k numbers out of 1 ... n.

For example,
If n = 4 and k = 2, a solution is:

[
  [2,4],
  [3,4],
  [2,3],
  [1,2],
  [1,3],
  [1,4],
]

*/

public class Solution {
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (n < 1 || k < 1) {
            return result;
        }
        
        List<Integer> all = new ArrayList<Integer>();
        for (int i = 1; i <= n; i++) {
            all.add(i);
        }
        
        search(k, new ArrayList<Integer>(), 0, all, result);
        return result;
    }
    
    public void search(int k, List<Integer> current, int index, List<Integer> all, List<List<Integer>> result) {
        if (current.size() == k) {
            result.add(new ArrayList<Integer>(current));
            return;
        }
        
        for (int i = index; i < all.size(); i++) {
            current.add(all.get(i));
            search(k, current, i + 1, all, result);
            current.remove(current.size() - 1);
        }
    }
}