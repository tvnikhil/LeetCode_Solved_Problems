/**
 * Definition for a binary tree node.
 * struct TreeNode {
 *     int val;
 *     TreeNode *left;
 *     TreeNode *right;
 *     TreeNode() : val(0), left(nullptr), right(nullptr) {}
 *     TreeNode(int x) : val(x), left(nullptr), right(nullptr) {}
 *     TreeNode(int x, TreeNode *left, TreeNode *right) : val(x), left(left), right(right) {}
 * };
 */
class Solution {
public:
    bool isCompleteTree(TreeNode* root) {
        queue<TreeNode *> childQ;
        childQ.push(root);
        bool foundNULL = false;
        while (!childQ.empty())
        {
            TreeNode *currNode = childQ.front();
            childQ.pop();
            if (!currNode)
                foundNULL = true;
            else
            {
                if (foundNULL)
                    return false;
                childQ.push(currNode->left);
                childQ.push(currNode->right);
            }
        }
        return true;
    }
};