/*

Given a binary tree, determine if it is height-balanced.

For this problem, a height-balanced binary tree is defined as a binary tree in which the depth of the two subtrees of every node never differ by more than 1.

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
    public boolean isBalanced(TreeNode root) {
        return getDepth(root) == -1 ? false : true;
    }
    
    // Bottom-up recursion
    // Depth of null node is 0
    // Return depth of subtree, or return -1 if it is not balanced
    public int getDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int left = getDepth(root.left);
        if (left == -1) {
            return -1;
        }
        
        int right = getDepth(root.right);
        if (right == -1) {
            return -1;
        }
        
        if (Math.abs(left - right) > 1) {
            return -1;
        }
        
        return left > right ? left + 1 : right + 1;
    }
}