/*

Reverse a linked list from position m to n. Do it in-place and in one-pass.

For example:
Given 1->2->3->4->5->NULL, m = 2 and n = 4,

return 1->4->3->2->5->NULL.

Note:
Given m, n satisfy the following condition:
1 ≤ m ≤ n ≤ length of list.

*/

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
public class Solution {
    public ListNode reverseBetween(ListNode head, int m, int n) {
        if (head == null || head.next == null) {
            return head;
        }
        if (m >= n) {
            return head;
        }
        
        // Find the start index node, and the node before it
        ListNode p = head;
        ListNode prev = null;
        int count = 1;
        while (p != null && count < m) {
            prev = p;
            p = p.next;
            count++;
        }
        
        // Reverse the list until nth node
        ListNode start = p;
        ListNode q = p;
        p = p.next;
        count++;
        while (p != null && count <= n) {
            ListNode temp = p.next;
            p.next = q;
            q = p;
            p = temp;
            count++;
        }
        
        // Set the connection between node inside (mth - nth) and outside (mth - nth)
        if (prev != null) {
            prev.next = q;
        } else {
            head = q;
        }
        start.next = p;
        
        return head;
    }
}