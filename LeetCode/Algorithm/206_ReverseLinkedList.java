/*

Reverse a singly linked list.

click to show more hints.

Hint:
A linked list can be reversed either iteratively or recursively. Could you implement both?

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
    public ListNode reverseList(ListNode head) {
        /**
         * Solve recursively
         */
        
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode temp = reverseList(head.next);
        // reverse current head with its head.next
        head.next.next = head;
        head.next = null;
        
        return temp;
        
        /**
         * Solve iteratively
         */
        // if (head == null || head.next == null) {
        //     return head;
        // }
        
        // ListNode temp = null;
        // ListNode current = head.next;
        // ListNode previous = head;
        // while (current != null) {
        //     temp = current.next;
        //     current.next = previous;
        //     if (previous == head) {
        //         previous.next = null;
        //     }
        //     previous = current;
        //     current = temp;
        // }
        // return previous;
    }
}