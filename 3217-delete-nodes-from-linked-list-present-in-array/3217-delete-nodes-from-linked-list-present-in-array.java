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
    public ListNode modifiedList(int[] nums, ListNode head) {
        Map<Integer, Integer> hm = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (hm.containsKey(nums[i]))
                continue;
            hm.put(nums[i], 1);
        }
        ListNode temp = head, prev = head;
        while (temp != null) {
            if (hm.containsKey(temp.val)) {
                if (head == temp) {
                    head = head.next;
                    temp = temp.next;
                    prev = temp;
                }
                else {
                    prev.next = temp.next;
                    temp = prev.next;
                }
            }
            else {
                prev = temp;
                temp = temp.next;
            }
        }
        return head;
    }
}