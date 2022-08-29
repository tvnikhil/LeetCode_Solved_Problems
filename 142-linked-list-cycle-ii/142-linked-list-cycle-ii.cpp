/**
 * Definition for singly-linked list.
 * struct ListNode {
 *     int val;
 *     ListNode *next;
 *     ListNode(int x) : val(x), next(NULL) {}
 * };
 */
class Solution {
public:
    ListNode *detectCycle(ListNode *head) {
        if (head == NULL)
            return NULL;
        map<ListNode*, ListNode*> hm1, hm2;
        ListNode *temp = head;
        while (temp) {
            if (hm1.find(temp) == hm1.end()) {
                hm1[temp] = temp->next;
                if (hm2.find(temp->next) == hm2.end())
                    hm2[temp->next] = temp;
            }
            else {
                // cout << temp->val << endl;
                // cout << hm2[temp]->val << endl;
                return hm2[temp]->next;
            }
            temp = temp->next;
        }
        return NULL;
    }
};