/*

Given inorder and postorder traversal of a tree, construct the binary tree.

Note:
You may assume that duplicates do not exist in the tree.

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
    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if (inorder == null || postorder == null) {
            return null;
        }
        if (inorder.length == 0 || postorder.length == 0 || inorder.length != postorder.length) {
            return null;
        }
        
        return buildTree(inorder, postorder, 0, inorder.length - 1, 0, postorder.length - 1);
    }
    
    public TreeNode buildTree(int[] inorder, int[] postorder, int startIn, int endIn, int startPost, int endPost) {
        if (startPost == endPost) {
            return new TreeNode(postorder[startPost]);
        }
        if (startPost > endPost) {
            return null;
        }
        
        // The last element of tree postorder should be the root
        // Then find the same element in inorder
        int rootIndex = 0;
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == postorder[endPost]) {
                rootIndex = i;
                break;
            }
        }
        // Divide inorder into left subtree and right subtree
        int leftSize = rootIndex - startIn;
        
        TreeNode root = new TreeNode(inorder[rootIndex]);
        // According to left and right size, divide the postorder and do recursion
        root.left = buildTree(inorder, postorder, startIn, rootIndex - 1, startPost, startPost + leftSize - 1);
        root.right = buildTree(inorder, postorder, rootIndex + 1, endIn, startPost + leftSize, endPost - 1);
        return root;
    }
}