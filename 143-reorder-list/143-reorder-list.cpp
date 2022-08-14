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
    ListNode* reverseList(ListNode* head) {
        ListNode *currNode = head, *prevNode = NULL, *nextNode = NULL;
        while (currNode != NULL) 
        {
            nextNode = currNode->next;
            currNode->next = prevNode;
            prevNode = currNode;
            currNode = nextNode;
        }
        return prevNode;
    }
    int size(ListNode* head) {
        int leng = 0;
        while (head != NULL) {
            leng++;
            head = head->next;
        }
        return leng;
    }
    void print(ListNode* head) {
        while (head != NULL) {
            cout << head->val << " ";
            head=head->next;
        }
        cout << endl;
    }
    void reorderList(ListNode* head) {
        int leng = size(head), limit = (leng%2 == 0) ? leng/2: (leng/2)+1;
        ListNode *p2 = head, *p2_parent = p2;
        for (int i = 0; i < limit; i++) {
            p2_parent = p2;
            p2 = p2->next;
        }
        p2_parent->next = reverseList(p2);
        p2 = p2_parent->next;
        ListNode* p1 = head;
        while (p2 != NULL) {
            ListNode *temp = p1->next;
            p1->next = p2_parent->next;
            p2_parent->next = p2->next;
            p2->next = temp;
            if (p1->next != NULL)
                p1 = p1->next->next;
            else {
                p2->next = NULL;
                break;
            }
            p2 = p2_parent->next;
        }
        if (leng % 2 == 0)
            p1->next = p2;
    }
};