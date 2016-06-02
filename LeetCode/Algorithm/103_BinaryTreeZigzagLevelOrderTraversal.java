/*

Given a binary tree, return the zigzag level order traversal of its nodes' values. (ie, from left to right, then right to left for the next level and alternate between).

For example:
Given binary tree {3,9,20,#,#,15,7},
    3
   / \
  9  20
    /  \
   15   7
return its zigzag level order traversal as:
[
  [3],
  [20,9],
  [15,7]
]
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
    public List<List<Integer>> zigzagLevelOrder(TreeNode root) {
        List<List<Integer>> result = new ArrayList<List<Integer>>();
        if (root == null) {
            return result;
        }
        
        // Add a flag to decide which direction to add
        boolean flag = true;
        List<TreeNode> list = new ArrayList<TreeNode>();
        list.add(root);
        while (!list.isEmpty()) {
            List<Integer> level = new ArrayList<Integer>();
            for (int i = 0; i < list.size(); i++) {
                level.add(list.get(i).val);
            }
            result.add(level);
            
            List<TreeNode> tempList = new ArrayList<TreeNode>(list);
            list = new ArrayList<TreeNode>();
            for (int i = tempList.size() - 1; i >= 0; i--) {
                TreeNode temp = tempList.get(i);
                if (flag) {
                    if (temp.right != null) {
                        list.add(temp.right);
                    }
                    if (temp.left != null) {
                        list.add(temp.left);
                    }
                } else {
                    if (temp.left != null) {
                        list.add(temp.left);
                    }
                    if (temp.right != null) {
                        list.add(temp.right);
                    }
                }
            }   
            
            flag = !flag;
        }
        
        return result;
    }
}