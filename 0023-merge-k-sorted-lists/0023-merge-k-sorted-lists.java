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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<Integer> heap = new PriorityQueue<>();
        ListNode ans = new ListNode(-1);
        
        for(int i = 0; i < lists.length; i++) {
            ListNode curr = lists[i];
            while (curr != null) {
                heap.offer(curr.val);
                curr = curr.next;
            }
        }
        
        ListNode curr = ans;
        while (heap.size() > 0) {
            curr.next = new ListNode(heap.poll());
            curr = curr.next;
        }
        
        return ans.next;
    }
}