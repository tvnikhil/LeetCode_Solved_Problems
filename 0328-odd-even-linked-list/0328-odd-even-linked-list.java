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
    public ListNode oddEvenList(ListNode head) {
        if (head == null)
            return head;
        ListNode lastNode = head;
        while (lastNode.next!= null)
            lastNode = lastNode.next;
        if (head.next == lastNode) return head;
        ListNode tempNode = lastNode;
        int i = 1;
        ListNode firstNode = head, prev = head;
        while (firstNode != null && firstNode != lastNode) {
            //System.out.println(firstNode.val + " " + prev.val + " " + tempNode.val);
            if (i % 2 == 0) {
                ListNode nextNode = firstNode.next;
                // put in last
                tempNode.next = firstNode;
                tempNode = tempNode.next;
                // tempNode.next = null;
                prev.next = nextNode;
            }
            prev = firstNode;
            firstNode = firstNode.next;
            i++;
            //System.out.println("af " + ""+ firstNode.val + " " + prev.val + " " + tempNode.val);
            if (firstNode == lastNode) break;
        }
        if (i % 2 == 0) {
            ListNode nextNode = firstNode.next;
            tempNode.next = firstNode;
            tempNode = tempNode.next;
            prev.next = nextNode;
        }
        tempNode.next = null;
        return head;
    }
}