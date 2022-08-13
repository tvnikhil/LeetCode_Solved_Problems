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
    ListNode* add2Numbers(ListNode* l1, ListNode* l2) {
        ListNode *currA = l1, *currB = l2, *nn = new ListNode(-1);
        ListNode *head = nn, *currC = head;
        int carry = 0;
        bool isCarry = false;
        while (currA != NULL && currB != NULL) 
        {
            int sum = currA->val + currB->val + carry;
            if (sum > 9) {
                isCarry = true;
                carry = 1;
                nn = new ListNode(sum % 10);
                currC->next = nn;
                currC = nn;
            }
            else {
                isCarry = false;
                carry = 0;
                nn = new ListNode(sum);
                currC->next = nn;
                currC = nn;
            }
            currA = currA->next;
            currB = currB->next;
        }
        while (currA != NULL) {
            int sum = currA->val + carry;
            if (sum > 9) {
                isCarry = true;
                carry = 1;
                nn = new ListNode(sum % 10);
                currC->next = nn;
                currC = nn;
            }
            else {
                isCarry = false;
                carry = 0;
                nn = new ListNode(sum);
                currC->next = nn;
                currC = nn;
            }
            currA=currA->next;
        }
        while (currB != NULL) {
            int sum = currB->val + carry;
            if (sum > 9) {
                isCarry = true;
                carry = 1;
                nn = new ListNode(sum % 10);
                currC->next = nn;
                currC = nn;
            }
            else {
                isCarry = false;
                carry = 0;
                nn = new ListNode(sum);
                currC->next = nn;
                currC = nn;
            }
            currB=currB->next;
        }
        if (isCarry == true) {
            nn = new ListNode(1);
            currC->next = nn;
            currC = nn;
        }
        return head->next;
    }
    ListNode* addTwoNumbers(ListNode* l1, ListNode* l2) {
        l1 = reverseList(l1);
        l2 = reverseList(l2);
        ListNode* ans = add2Numbers(l1, l2);
        return reverseList(ans);
    }
};