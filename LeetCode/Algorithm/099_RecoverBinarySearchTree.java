/*

Two elements of a binary search tree (BST) are swapped by mistake.

Recover the tree without changing its structure.

Note:
A solution using O(n) space is pretty straight forward. Could you devise a constant space solution?
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
    public void recoverTree(TreeNode root) {
        if (root == null) {
            return;
        }
        
        TreeNode previous = null;
        TreeNode parent = null;
        TreeNode current = root;
        
        TreeNode nodeA = null;
        TreeNode nodeB = null;
        boolean foundA = false;
        
        // Using Threaded Binary Tree 
        while (current != null) {
            if (current.left == null) {
                // If no left node, then check and go right
                // When check root, there is no parent, so just go next
                if (parent != null && parent.val > current.val) {
                    if (!foundA) {
                        nodeA = parent;
                        foundA = true;
                    }
                    nodeB = current;
                }
                parent = current;
                current = current.right;
            } else {
                previous = current.left;
                // Find the right most node under current.left
                while (previous.right != null && previous.right != current) {
                    previous = previous.right;
                }
                if (previous.right == null) {
                    // If its right has not been set, set it point to current
                    previous.right = current;
                    current = current.left;
                } else {
                    // else remove the right pointer and check
                    previous.right = null;
                    if (parent != null && parent.val > current.val) {
                        if (!foundA) {
                            nodeA = parent;
                            foundA = true;
                        }
                        nodeB = current;
                    }
                    parent = current;
                    current = current.right;
                }
            }
        }
        
        if (nodeA != null && nodeB != null) {
            int temp = nodeA.val;
            nodeA.val = nodeB.val;
            nodeB.val = temp;
        }
    }
}