/*

Given a binary tree and a sum, find all root-to-leaf paths where each path's sum equals the given sum.

For example:
Given the below binary tree and sum = 22,
              5
             / \
            4   8
           /   / \
          11  13  4
         /  \    / \
        7    2  5   1
return
[
   [5,4,11,2],
   [5,8,4,5]
]

*/

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public List<List<Integer>> pathSum(TreeNode root, int sum) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        findPath(root, sum, new ArrayList<Integer>(), result);
        return result;
    }
    
    public void findPath(TreeNode root, int sum, List<Integer> current, List<List<Integer>> result) {
        if (root.left == null && root.right == null) {
            if (root.val == sum) {
                current.add(root.val);
                result.add(new ArrayList<Integer>(current));
                current.remove(current.size() - 1);
            }
            return;
        }
        
        if (root.left == null) {
            current.add(root.val);
            findPath(root.right, sum - root.val, current, result);
            current.remove(current.size() - 1);
            return;
        }
        
        if (root.right == null) {
            current.add(root.val);
            findPath(root.left, sum - root.val, current, result);
            current.remove(current.size() - 1);
            return;
        }
        
        current.add(root.val);
        findPath(root.left, sum - root.val, current, result);
        findPath(root.right, sum - root.val, current, result);
        current.remove(current.size() - 1);
    }
}