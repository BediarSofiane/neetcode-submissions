/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode fast = head;
        for (int i = 0; i < n; i++) {
            fast = fast.next;
        }
        ListNode slow = head;
        ListNode previous = null;
        while (fast != null) {
            fast = fast.next;
            previous = slow;
            slow = slow.next;
        }
        if (previous != null) {
            previous.next = slow.next;
            slow.next = null;
        } else {
            ListNode tmp = head.next;
            head.next = null;
            head = tmp;
        }
        return head;
    }
}
