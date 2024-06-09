/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
class Solution {
    public void deleteNode(ListNode node) {
        ListNode prev = node;
        ListNode curr = node.next;
        while (true) {
            int temp = prev.val;
            prev.val = curr.val;
            curr.val = temp;
            if (curr.next == null) {
                prev.next = null;
                break;
            }
            prev = prev.next;
            curr = curr.next;
        }
    }
}