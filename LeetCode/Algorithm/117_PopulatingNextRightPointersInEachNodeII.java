/*

Follow up for problem "Populating Next Right Pointers in Each Node".

What if the given tree could be any binary tree? Would your previous solution still work?

Note:

You may only use constant extra space.
For example,
Given the following binary tree,
         1
       /  \
      2    3
     / \    \
    4   5    7
After calling your function, the tree should look like:
         1 -> NULL
       /  \
      2 -> 3 -> NULL
     / \    \
    4-> 5 -> 7 -> NULL

*/

/**
 * Definition for binary tree with next pointer.
 * public class TreeLinkNode {
 *     int val;
 *     TreeLinkNode left, right, next;
 *     TreeLinkNode(int x) { val = x; }
 * }
 */
public class Solution {
    public void connect(TreeLinkNode root) {
        if (root == null) {
            return;
        }
        
        connectNext(root);
    }
    
    public void connectNext(TreeLinkNode root) {
        TreeLinkNode temp = root.next;
        while (temp != null) {
            if (temp.left != null) {
                temp = temp.left;
                break;
            }
            if (temp.right != null) {
                temp = temp.right;
                break;
            }
            temp = temp.next;
        }
        
        if (root.left != null && root.right != null) {
            root.left.next = root.right;
            root.right.next = temp;
            
            // Here we must DFS right subtree first
            // otherwise if the while loop above may miss partial right subtree
            // due to some links have not been connected yet (if we do left first)
            connectNext(root.right);
            connectNext(root.left);
        } else {
            if (root.left != null) {
                root.left.next = temp;
                
                connectNext(root.left);
            } else if (root.right != null) {
                root.right.next = temp;
                
                connectNext(root.right);
            } else {
                return;
            }
        }
    }
}