/*



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
    public ListNode mergeKLists(ListNode[] lists) {
        int size = lists.length;
        
        if (size == 0) {
            return null;
        }
        
        if (size == 1) {
            return lists[0];
        } 
        
        ListNode[] newLists = new ListNode[(size + 1) / 2];
        for (int i = 0; i < newLists.length; i++) {
            if (2 * i + 1 >= size) {
                newLists[i] = lists[2 * i];
            } else {
                newLists[i] = merge(lists[2 * i], lists[2 * i + 1]);
            }
        }
        
        return mergeKLists(newLists);
    }
    
    public ListNode merge(ListNode nodeOne, ListNode nodeTwo) {
        if (nodeOne == null) {
            return nodeTwo;
        }
        
        if (nodeTwo == null) {
            return nodeOne;
        }
        
        ListNode head = null;
        if (nodeOne.val < nodeTwo.val) {
            head = new ListNode(nodeOne.val);
            nodeOne = nodeOne.next;
        } else {
            head = new ListNode(nodeTwo.val);
            nodeTwo = nodeTwo.next;
        }
        ListNode start = head;
        
        while (nodeOne != null && nodeTwo != null) {
            if (nodeOne.val < nodeTwo.val) {
                start.next = new ListNode(nodeOne.val);
                start = start.next;
                nodeOne = nodeOne.next;
            } else {
                start.next = new ListNode(nodeTwo.val);
                start = start.next;
                nodeTwo = nodeTwo.next;
            }
        }
        
        while (nodeOne != null) {
            start.next = new ListNode(nodeOne.val);
            start = start.next;
            nodeOne = nodeOne.next;
        }
        
        while (nodeTwo != null) {
            start.next = new ListNode(nodeTwo.val);
            start = start.next;
            nodeTwo = nodeTwo.next;
        }
        
        return head;
    }
}