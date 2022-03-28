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
    ListNode* reverseBetween(ListNode* head, int left, int right) {
        if (left == right)
            return head;
        stack<int> s;
        ListNode* temp = head;
        int i = 1, ti = 1;
        while (i < left) {
            temp = temp->next;
            i++;
        }
        ListNode* t = temp;
        ti = i;
        while (i <= right)
        {
            s.push(temp->val);
            temp = temp->next;
            i++;
        }
        while (ti <= right)
        {
            t->val = s.top();
            s.pop();
            t = t->next;
            ti++;
        }
        return head;
    }
};