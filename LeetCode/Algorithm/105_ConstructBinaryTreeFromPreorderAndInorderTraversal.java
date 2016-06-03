/*

Given preorder and inorder traversal of a tree, construct the binary tree.

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
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        if (preorder == null || inorder == null) {
            return null;
        }
        
        if (preorder.length == 0 || inorder.length == 0 || preorder.length != inorder.length) {
            return null;
        }
        
        return buildTree(preorder, inorder, 0, preorder.length - 1, 0, inorder.length - 1);
    }
    
    public TreeNode buildTree(int[] preorder, int[] inorder, int startPre, int endPre, int startIn, int endIn) {
        if (startPre == endPre) {
            TreeNode temp = new TreeNode(preorder[startPre]);
            return temp;
        }
        if (startPre > endPre) {
            return null;
        }
        
        // The first element of tree preorder should be the root
        // Then find the same element in inorder
        int rootIndex = 0;
        for (int i = startIn; i <= endIn; i++) {
            if (inorder[i] == preorder[startPre]) {
                rootIndex = i;
                break;
            }
        }
        
        // Divide inorder into left subtree and right subtree
        int leftSize = rootIndex - startIn;
        int rightSize = endIn - rootIndex;
        TreeNode root = new TreeNode(preorder[startPre]);
        // According to left and right size, divide the preorder and do recursion
        root.left = buildTree(preorder, inorder, startPre + 1, startPre + leftSize, startIn, rootIndex - 1);
        root.right = buildTree(preorder, inorder, startPre + leftSize + 1, endPre, rootIndex + 1, endIn);
        return root;
    }
}