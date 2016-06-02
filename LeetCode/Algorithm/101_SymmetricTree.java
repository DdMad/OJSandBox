/*

Given a binary tree, check whether it is a mirror of itself (ie, symmetric around its center).

For example, this binary tree is symmetric:

    1
   / \
  2   2
 / \ / \
3  4 4  3
But the following is not:
    1
   / \
  2   2
   \   \
   3    3
Note:
Bonus points if you could solve it both recursively and iteratively.

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
    public boolean isSymmetric(TreeNode root) {
        if (root == null) {
            return true;
        }
        
        /**
         * Iterative solution
         */
        // Stack<TreeNode> leftList = new Stack<TreeNode>();
        // leftList.add(root.left);
        // Stack<TreeNode> rightList = new Stack<TreeNode>();
        // rightList.add(root.right);
        // while (!leftList.isEmpty() && !rightList.isEmpty()) {
        //     TreeNode left = leftList.pop();
        //     TreeNode right = rightList.pop();
                    
        //     if (left == null && right == null) {
        //         continue;
        //     }
        //     if (left == null || right == null) {
        //         return false;
        //     }
            
        //     if (left.val != right.val) {
        //         return false;
        //     } else {
        //         leftList.push(left.left);
        //         leftList.push(left.right);
        //         rightList.push(right.right);
        //         rightList.push(right.left);
        //     }
        // }
        
        // return true;
        
        return isSymmetric(root.left, root.right);
    }
    
    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) {
            return true;
        }
        if (left == null || right == null) {
            return false;
        }
        
        return left.val == right.val && isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }
}