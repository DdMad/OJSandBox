/*

Given a sorted linked list, delete all duplicates such that each element appear only once.

For example,
Given 1->1->2, return 1->2.
Given 1->1->2->3->3, return 1->2->3.

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
    public ListNode deleteDuplicates(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode h = head;
        ListNode current = head;
        ListNode prev = null;
        
        while (current != null) {
            // First time
            if (prev == null) {
                prev = current;
                current = current.next;
            } else {
                // Duplicate found
                if (current.val == prev.val) {
                    // Jump over all duplicates
                    while (current != null && current.val == prev.val) {
                        current = current.next;
                    }
                    
                    prev.next = current;
                    prev = prev.next;
                    if (current != null) {
                        current = current.next;
                    }
                } else {
                    current = current.next;
                    prev = prev.next;
                }
            }
        }
        
        return h;
    }
}