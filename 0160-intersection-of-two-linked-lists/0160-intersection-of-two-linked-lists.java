/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public int returnLength(ListNode head) {
        int len = 0;
        ListNode temp = head;
        while (temp != null) {
            len++;
            temp = temp.next;
        }
        return len;
    }
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int lenA = returnLength(headA), lenB = returnLength(headB);
        ListNode tempA = headA, tempB = headB;
        if (lenA < lenB) {
            for (int i = 0; i < lenB - lenA; i++)
                tempB = tempB.next;
        }
        else if (lenA > lenB) {
            for (int i = 0; i < lenA - lenB; i++)
                tempA = tempA.next;
        }
        while (tempA != tempB && tempA != null && tempB != null) {
            tempA = tempA.next;
            tempB = tempB.next;
        }
        if (tempA != null && tempB != null)
            return tempA;
        return null;
    }
}