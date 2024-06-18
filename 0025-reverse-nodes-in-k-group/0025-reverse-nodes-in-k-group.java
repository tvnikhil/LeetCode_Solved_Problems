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
class ListNodePairs {
    ListNode head;
    ListNode tail;
    ListNodePairs(ListNode head, ListNode tail) {
        this.head = head;
        this.tail = tail;
    }
}

class Solution {
    public ListNodePairs reverseList(ListNode f) {
        ListNode prev = f, curr = f.next;
        ListNode tail = f;
        while (curr != null) {
            ListNode temp = curr.next;
            curr.next = prev;
            if (prev == f)
                prev.next = null;
            prev = curr;
            curr = temp;
        }
        return new ListNodePairs(prev, tail);
    }
    
    public ListNode reverseKGroup(ListNode head, int k) {
        if (head == null)
            return head;
        ListNode curr = head, nextNode = null;
        ListNode prevFirst = new ListNode(-1), ansHead = prevFirst;
        prevFirst.next = head;
        int i = 1;
        while (curr != null) {
            if (i == k) {
                nextNode = curr.next;
                curr.next = null;
                ListNodePairs rPair = reverseList(prevFirst.next);
                prevFirst.next = rPair.head;
                ListNode tail = rPair.tail;
                prevFirst = tail;
                tail.next = nextNode;
                curr = nextNode;
                i = 1;
            }
            if (curr == null)
                break;
            curr = curr.next;
            i++;
        }
        return ansHead.next;
    }
}