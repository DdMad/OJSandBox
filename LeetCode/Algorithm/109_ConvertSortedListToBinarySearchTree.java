/*

Given a singly linked list where elements are sorted in ascending order, convert it to a height balanced BST.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
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
    public TreeNode sortedListToBST(ListNode head) {
        int length = 0;
        ListNode temp = head;
        while (temp != null) {
            length++;
            temp = temp.next;
        }
        if (length == 0) {
            return null;
        }
        
        temp = head;
        // Here we wrap the ListNode to List because it will not pass reference if we pass ListNode directly.
        // Alternative is convert Link List to Array or ArrayList first, then use same method in previous problem.
        // But alternative costs more space
        // Space: this: O(logN); alternative: O(N)
        List<ListNode> list = new ArrayList<ListNode>();
        list.add(temp);
        return sortedListToBST(list, 0, length - 1);
    }
    
    public TreeNode sortedListToBST(List<ListNode> list, int start, int end) {
        if (start > end) {
            return null;
        }
        
        int mid = (start + end) / 2;
        TreeNode left = sortedListToBST(list, start, mid - 1);
        TreeNode root = new TreeNode(list.get(0).val);
        root.left = left;
        list.set(0, list.get(0).next);
        root.right = sortedListToBST(list, mid + 1, end);
        return root;
    }
}