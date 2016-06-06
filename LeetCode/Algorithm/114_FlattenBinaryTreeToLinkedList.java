/*

Given a binary tree, flatten it to a linked list in-place.

For example,
Given

         1
        / \
       2   5
      / \   \
     3   4   6
The flattened tree should look like:
   1
    \
     2
      \
       3
        \
         4
          \
           5
            \
             6
click to show hints.

Hints:
If you notice carefully in the flattened tree, each node's right child points to the next node of a pre-order traversal.

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
    public void flatten(TreeNode root) {
        if (root == null) {
            return;
        }
        
        flattenTree(root);
    }
    
    // Return the last node of this subtree in pre-order traversal
    public TreeNode flattenTree(TreeNode root) {
        if (root.left == null && root.right == null) {
            return root;
        } else if (root.right == null) {
            TreeNode leftLast = flattenTree(root.left);
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            return leftLast;
        } else if (root.left == null) {
            return flattenTree(root.right);
        } else {
            // Find the last node of left subtree and right subtree
            // Set leftLast.right=root.right
            // Then set root.right=root.left
            // Lastly set root.left=null
            // Return rightLast
            TreeNode leftLast = flattenTree(root.left);
            TreeNode rightLast = flattenTree(root.right);
            leftLast.right = root.right;
            root.right = root.left;
            root.left = null;
            return rightLast;
        }
    }
}