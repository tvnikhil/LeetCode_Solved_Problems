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
    ListNode merge(ListNode left, ListNode right) {
        ListNode p1 = left, p2 = right;
        ListNode temp = new ListNode(-1);
        ListNode newHead = temp;
        while (p1 != null && p2 != null) {
            if (p1.val < p2.val) {
                newHead.next = new ListNode(p1.val);
                newHead = newHead.next;
                p1 = p1.next;
            }
            else {
                newHead.next = new ListNode(p2.val);
                newHead = newHead.next;
                p2 = p2.next;
            }
        }
        while (p1 != null) {
            newHead.next = new ListNode(p1.val);
            newHead = newHead.next;
            p1 = p1.next;
        }
        while (p2 != null) {
            newHead.next = new ListNode(p2.val);
            newHead = newHead.next;
            p2 = p2.next;
        }
        return temp.next;
    }
    
    ListNode mergeSort(ListNode head) {
        if (head == null || head.next == null)
            return head;
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        ListNode rightHead = slow.next, leftHead = head;
        slow.next = null;
        leftHead = mergeSort(leftHead);
        rightHead = mergeSort(rightHead);
        return merge(leftHead, rightHead);
    }
    public ListNode sortList(ListNode head) {
        head = mergeSort(head);
        return head;
    }
}