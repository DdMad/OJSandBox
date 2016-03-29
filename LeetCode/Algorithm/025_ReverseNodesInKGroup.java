/*

Given a linked list, reverse the nodes of a linked list k at a time and return its modified list.

If the number of nodes is not a multiple of k then left-out nodes in the end should remain as it is.

You may not alter the values in the nodes, only nodes itself may be changed.

Only constant memory is allowed.

For example,
Given this linked list: 1->2->3->4->5

For k = 2, you should return: 2->1->4->3->5

For k = 3, you should return: 3->2->1->4->5

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
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode start = head;
        ListNode newHead = getKthNode(start, k);
        ListNode end = newHead;
        if (newHead == null) {
            return head;
        }
        
        ListNode one = null;
        ListNode two = null;
        ListNode next = null;
        while (start != null && end != null) {
            one = start;
            two = start.next;
            
            for (int i = 0; i < k - 1; i++) {
                next = two.next;
                two.next = one;
                one = two;
                two = next;
            }
            
            end = getKthNode(two, k);
            if (end == null) {
                start.next = two;
                break;
            } else {
                start.next = end;
                start = two;
            }
        }
        
        return newHead;
    }
    
    public ListNode getKthNode(ListNode start, int k) {
        int index = 0;
        ListNode previous = null;
        
        while (index < k) {
            if (start == null) {
                return null;
            } else {
                previous = start;
                start = start.next;
                index++;
            }
        }
        
        return previous;
    }
}