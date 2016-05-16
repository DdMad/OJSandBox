/*

Given a sorted linked list, delete all nodes that have duplicate numbers, leaving only distinct numbers from the original list.

For example,
Given 1->2->3->3->4->4->5, return 1->2->5.
Given 1->1->1->2->3, return 2->3.

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
        
        // Find head
        ListNode current = head;
        ListNode h = findNext(current);
        // If only head or no head
        if (h == null || h.next == null) {
            return h;
        }
        
        ListNode constHead = h;
        current = h.next;
        while(current != null) {
            ListNode temp = findNext(current);
            h.next = temp;
            if (temp == null) {
                break;
            }
            
            h = h.next;
            current = temp.next;
        }
        
        return constHead;
    }
    
    // Find next distinct element
    // Return null if not found
    public ListNode findNext(ListNode current) {
        ListNode temp = null;
        ListNode prev = null;
        
        while (current != null) {
            // First time
            if (prev == null) {
                // Only one element left in the list during first time
                if (current.next == null) {
                    temp = current;
                    break;
                } else {
                    if (current.val != current.next.val) {
                        temp = current;
                        break;
                    } else {
                        prev = current;
                        current = current.next;
                    }
                }
            // Last element in the list
            } else if (current.next == null) {
                if (current.val != prev.val) {
                    temp = current;
                    break;
                } else {
                    prev = prev.next;
                    current = current.next;
                }
            // Middle element
            } else {
                if (current.val != current.next.val && current.val != prev.val) {
                    temp = current;
                    break;
                } else {
                    prev = prev.next;
                    current = current.next;
                }
            }
        }
        
        return temp;
    }
}