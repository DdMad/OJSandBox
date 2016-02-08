/*

You are given two linked lists representing two non-negative numbers. The digits are stored in reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked list.

Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8

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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        ListNode head = new ListNode((l1.val + l2.val) % 10);
        ListNode result = head;
        
        int c = (l1.val + l2.val) / 10;
        
        while (l1.next != null && l2.next != null) {
            l1 = l1.next;
            l2 = l2.next;
            
            ListNode temp = new ListNode((l1.val + l2.val + c) % 10);
            c = (l1.val + l2.val + c) / 10;
            head.next = temp;
            head = temp;
        }
        
        while (l1.next != null) {
            l1 = l1.next;
            
            ListNode temp = new ListNode((l1.val + c) % 10);
            c = (l1.val + c) / 10;
            head.next = temp;
            head = temp;
        }
        
        while (l2.next != null) {
            l2 = l2.next;
            
            ListNode temp = new ListNode((l2.val + c) % 10);
            c = (l2.val + c) / 10;
            head.next = temp;
            head = temp;
        }
        
        if (c > 0) {
            ListNode temp = new ListNode(c % 10);
            head.next = temp;
            head = temp;
        }
        
        return result;
    }
}