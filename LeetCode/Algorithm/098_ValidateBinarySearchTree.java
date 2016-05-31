/*

Given a binary tree, determine if it is a valid binary search tree (BST).

Assume a BST is defined as follows:

The left subtree of a node contains only nodes with keys less than the node's key.
The right subtree of a node contains only nodes with keys greater than the node's key.
Both the left and right subtrees must also be binary search trees.
confused what "{1,#,2,3}" means? > read more on how binary tree is serialized on OJ.


OJ's Binary Tree Serialization:
The serialization of a binary tree follows a level order traversal, where '#' signifies a path terminator where no node exists below.

Here's an example:
   1
  / \
 2   3
    /
   4
    \
     5
The above binary tree is serialized as "{1,2,3,#,#,4,#,#,5}".

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
    public boolean isValidBST(TreeNode root) {
        if (root == null) {
            return true;
        }
        return validateBST(root, false, 0, false, 0);
    }
    
    // Set hasMin and hasMax for the situation that node not have min or max
    public boolean validateBST(TreeNode root, boolean hasMin, int min, boolean hasMax, int max) {
        if (root == null) {
            return true;
        }
        if ((hasMin && root.val <= min) || (hasMax && root.val >= max)) {
            return false;
        }
        
        return validateBST(root.left, hasMin, min, true, root.val) &&
            validateBST(root.right, true, root.val, hasMax, max);
    }
}