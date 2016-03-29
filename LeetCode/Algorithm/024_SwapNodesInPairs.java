/*

Given a linked list, swap every two adjacent nodes and return its head.

For example,
Given 1->2->3->4, you should return the list as 2->1->4->3.

Your algorithm should use only constant space. You may not modify the values in the list, only nodes itself can be changed.

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
    public ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        
        ListNode start = head;
        ListNode nextNode = null;
        ListNode newHead = head.next;
        
        ListNode one = null;
        ListNode two = null;
        while (start != null && start.next != null) {
            one = start;
            two = start.next;
            
            nextNode = two.next;
            two.next = one;
            if (nextNode == null) {
                one.next = null;
                break;
            } else if (nextNode.next == null) {
                one.next = nextNode;
            } else {
                one.next = nextNode.next;
            }
            start = nextNode;
        }
        
        return newHead;
    }
}