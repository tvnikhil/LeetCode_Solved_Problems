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
    public ListNode reverseList(ListNode head) {
        if (head == null)
            return head;
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            if (prev == head)
                prev.next = null;
            prev = curr;
            curr = temp;
        }
        return prev;
    }
}