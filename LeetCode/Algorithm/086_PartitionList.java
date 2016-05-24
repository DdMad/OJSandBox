/*

Given a linked list and a value x, partition it such that all nodes less than x come before nodes greater than or equal to x.

You should preserve the original relative order of the nodes in each of the two partitions.

For example,
Given 1->4->3->2->5->2 and x = 3,
return 1->2->2->4->3->5.

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
    public ListNode partition(ListNode head, int x) {
        if (head == null) {
            return head;
        }
        
        // Two pointers
        // One records < x, one records >= x
        ListNode smallHead = null;
        ListNode largeHead = null;
        ListNode smallCurrent = null;
        ListNode largeCurrent = null;
        ListNode current = head;
        while (current != null) {
            if (current.val < x) {
                if (smallHead == null) {
                    smallHead = current;
                    smallCurrent = smallHead;
                } else {
                    smallCurrent.next = current;
                    smallCurrent = smallCurrent.next;
                }
            } else {
                if (largeHead == null) {
                    largeHead = current;
                    largeCurrent = largeHead;
                } else {
                    largeCurrent.next = current;
                    largeCurrent = largeCurrent.next;
                }
            }
            current = current.next;
        }
        
        // In the end, combine two list
        if (smallHead == null) {
            largeCurrent.next = null;
            return largeHead;
        } else if (largeHead == null) {
            smallCurrent.next = null;
            return smallHead;
        } else {
            smallCurrent.next = largeHead;
            largeCurrent.next = null;
            return smallHead;
        }
    }
}