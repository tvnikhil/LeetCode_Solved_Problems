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
    ListNode* rotateRight(ListNode* head, int k) {
        if (head == NULL)
            return head;
        deque<int> dq;
        ListNode *temp = head;
        while (temp) {
            dq.push_back(temp->val);
            temp = temp->next;
        }
        k = k % dq.size();
        while (k--) {
            int temp = dq.back();
            dq.pop_back();
            dq.push_front(temp);
        }
        temp = head;
        int i = 0;
        while (temp) {
            temp->val = dq[i++];
            temp = temp->next;
        }
        return head;
    }
};