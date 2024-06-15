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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode slow = head, fast = head;
        int len = 1, i = 0;
        for (; i < k; i++) {
            if (fast.next != null) {
                fast = fast.next;
                len++;
            }
            else {
                k = k % (len);
                k++;
                i = 0;
                fast = head;
            }
        }
        while (fast.next != null) {
            slow = slow.next;
            fast = fast.next;
        }
        fast.next = head;
        head = slow.next;
        slow.next = null;
        return head;
    }
}