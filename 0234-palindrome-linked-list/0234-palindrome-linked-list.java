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
    ListNode reverseList(ListNode head) {
        ListNode prev = head, curr = head.next;
        while (curr != null) {
            ListNode nextNode = curr.next;
            curr.next = prev;
            if (prev == head)
                prev.next = null;
            prev = curr;
            curr = nextNode;
        }
        return prev;
    }
    public boolean isPalindrome(ListNode head) {
        if (head == null || head.next == null)
            return true;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode revHead = reverseList(slow.next);
        ListNode temp1 = head, temp2 = revHead;
        while (temp1 != null && temp2 != null) {
            if (temp1.val == temp2.val)
            {
                temp1 = temp1.next;
                temp2 = temp2.next;
            }
            else
                return false;
        }
        return true;
    }
}