/*

Merge two sorted linked lists and return it as a new list. The new list should be made by splicing together the nodes of the first two lists.

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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        
        if (l2 == null) {
            return l1;
        }
        
        ListNode head = null;
        if (l1.val < l2.val) {
            head = new ListNode(l1.val);
            l1 = l1.next;
        } else {
            head = new ListNode(l2.val);
            l2 = l2.next;
        }
        ListNode start = head;
        
        while (l1 != null && l2 != null) {
            if (l1.val < l2.val) {
                start.next = new ListNode(l1.val);
                start = start.next;
                l1 = l1.next;
            } else {
                start.next = new ListNode(l2.val);
                start = start.next;
                l2 = l2.next;
            }
        }
        
        while (l1 != null) {
            start.next = new ListNode(l1.val);
            start = start.next;
            l1 = l1.next;
        }
        
        while (l2 != null) {
            start.next = new ListNode(l2.val);
            start = start.next;
            l2 = l2.next;
        }
        
        return head;
    }
}