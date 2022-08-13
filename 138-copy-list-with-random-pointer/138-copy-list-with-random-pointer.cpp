/*
// Definition for a Node.
class Node {
public:
    int val;
    Node* next;
    Node* random;
    
    Node(int _val) {
        val = _val;
        next = NULL;
        random = NULL;
    }
};
*/

class Solution {
public:
    Node* copyRandomList(Node* head) {
        map<int, Node*> idx_addr, new_idx_addr;
        map<Node*, int> addr_idx;
        Node *temp = head, *newList;
        //
        int idx = 0;
        while(temp != NULL) {
            addr_idx[temp] = idx;
            idx_addr[idx++] = temp;
            temp = temp->next;
        }
        temp = head;
        //
        newList = new Node(-1);
        Node *curr = newList;
        while (temp != NULL) {
            curr->next = new Node(temp->val);
            curr = curr->next;
            temp = temp->next;
        }
        newList = newList->next;
        //
        curr = newList;
        idx = 0;
        while (curr != NULL) {
            new_idx_addr[idx++] = curr;
            curr = curr->next;
        }
        //
        for (int i = 0; i < (int) new_idx_addr.size(); i++) {
            if (idx_addr[i]->random == NULL) {
                new_idx_addr[i]->random = NULL;
            }
            else {
                idx = addr_idx[idx_addr[i]->random];
                new_idx_addr[i]->random = new_idx_addr[idx];
            }
        }
        return newList;
    }
};