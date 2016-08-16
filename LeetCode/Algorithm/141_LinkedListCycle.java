/*

Given a linked list, determine if it has a cycle in it.

Follow up:
Can you solve it without using extra space?

*/

/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        if (head == null) {
            return false;
        }
        
        ListNode fast = head;
        ListNode slow = head;
        
        do {
            if (fast.next != null) {
                fast = fast.next;
            } else {
                return false;
            }
            
             if (fast.next != null) {
                fast = fast.next;
            } else {
                return false;
            }
            
            // Already check null in the fast
            slow = slow.next;
        } while (fast != slow);
        
        return true;
    }
}