/*

Given n, generate all structurally unique BST's (binary search trees) that store values 1...n.

For example,
Given n = 3, your program should return all 5 unique BST's shown below.

   1         3     3      2      1
    \       /     /      / \      \
     3     2     1      1   3      2
    /     /       \                 \
   2     1         2                 3
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
    public List<TreeNode> generateTrees(int n) {
        if (n <= 0) {
            return new ArrayList<TreeNode>();
        }
        
        return findBST(1, n);
    }
    
    public List<TreeNode> findBST(int start, int end) {
        List<TreeNode> result = new ArrayList<TreeNode>();
        if (start > end) {
            result.add(null);
            return result;
        }
        
        for (int i = start; i <= end; i++) {
            // Find all left and right possible nodes.
            List<TreeNode> leftBST = findBST(start, i - 1);
            List<TreeNode> rightBST = findBST(i + 1, end);
            for (TreeNode left : leftBST) {
                for (TreeNode right : rightBST) {
                    // Create the root node
                    TreeNode root = new TreeNode(i);
                    root.left = left;
                    root.right = right;
                    // Add to result
                    result.add(root);
                }
            }
        }
        
        return result;
    }
}