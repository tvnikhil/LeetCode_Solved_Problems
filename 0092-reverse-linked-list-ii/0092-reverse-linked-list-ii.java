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
    public ListNode reverseBetween(ListNode head, int left, int right) {
        if (head.next == null)
            return head;
        ListNode nHead = null;
        ListNode temp = head;
        ListNode leftPtr = null, rightPtr = null;
        ListNode bLeftPtr = null, afRightPtr = null;
        if (left == 1) {
            ListNode nn = new ListNode(-501);
            nn.next = head;
            head = nn;
            temp = head;
        }
        int i = 1;
        if (left == 1) i = 0;
        for (; ; i++) {
            if (i+1 == left) {
                bLeftPtr = temp;
            }
            if (i >= left && i <= right) {
                ListNode nn = new ListNode(temp.val);
                nn.next = nHead;
                if (nHead == null) {
                    afRightPtr = nn;
                    nHead = nn;
                }
                else
                    nHead = nn;
            }
            if (i > right) {
                afRightPtr.next = temp;
                if (bLeftPtr != null)
                    bLeftPtr.next = nHead;
                break;
            }
            temp = temp.next;
        }
        if (head.val != -501)
            return head;
        return head.next;
    }
}