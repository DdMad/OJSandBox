/*

Given a binary tree, find its minimum depth.

The minimum depth is the number of nodes along the shortest path from the root node down to the nearest leaf node.

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
    public int minDepth(TreeNode root) {
        if (root == null) {
            return 0;
        }
        
        int depth = 1;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        
        while (!list.isEmpty()) {
            List<TreeNode> tempList = new ArrayList<TreeNode>();
            for (TreeNode node : list) {
                if (node.left == null && node.right == null) {
                    // If both left and right child are null, return depth
                    return depth;
                } else {
                    // Only one child is null, should continue check the other child
                    if (node.left != null) {
                        tempList.add(node.left);
                    }
                    if (node.right != null) {
                        tempList.add(node.right);
                    }
                }
            }
            list = tempList;
            depth++;
        }
        return depth;
    }
}