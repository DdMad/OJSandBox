/*

Given a binary tree, find its maximum depth.

The maximum depth is the number of nodes along the longest path from the root node down to the farthest leaf node.

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
    public int maxDepth(TreeNode root) {
        return findMaxDepth(root, 0);
    }
    
    public int findMaxDepth(TreeNode root, int max) {
        if (root == null) {
            return max;
        }
        
        // Find max depth of left and right, return larger one
        int leftMax = findMaxDepth(root.left, max + 1);
        int rightMax = findMaxDepth(root.right, max + 1);
        return leftMax > rightMax ? leftMax : rightMax;
    }
}