/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode() : val(0), next(nullptr) {}
 *     ListNode(int x) : val(x), next(nullptr) {}
 *     ListNode(int x, ListNode *next) : val(x), next(next) {}
 * };
 */
class Solution {
public:
    ListNode *reverseList(ListNode *head) {
        ListNode *temp = NULL;
        while (head) {
            ListNode *next = head->next;
            head->next = temp;
            temp = head;
            head = next;
        }
        return temp;
    }
    bool isPalindrome(ListNode* head) {
        if (head == NULL || head->next == NULL)
            return head;
        ListNode *slow = head, *fast = head;
        while (fast->next && fast->next->next) {
            slow = slow->next;
            fast = fast->next->next;
        }
        slow = slow->next;
        slow = reverseList(slow);
        ListNode *temp = head;
        while (slow) {
            if (temp->val != slow->val)
                return 0;
            temp = temp->next;
            slow = slow->next;
        }
        return 1;
    }
};