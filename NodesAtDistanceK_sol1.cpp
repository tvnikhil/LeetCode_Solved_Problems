#include <iostream>
#include <algorithm>
#include <vector>
#include <list>
#include <queue>
#include <deque>
#include <stack>
#include <map>
#include <set>
#include <unordered_set>
#include <unordered_map>
#include <iterator>
#include <cstdio>
#include <cstring>
#include <cstdlib>
#include <cmath>
#include <string>
using namespace std;

class TreeNode
{
public:
    int val;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int d)
    {
        val = d;
        left = NULL;
        right = NULL;
    }
};

class Solution
{
public:
    void levelOrder(TreeNode *root, unordered_map<int, TreeNode *> &parentNodes)
    {
        queue<TreeNode *> childQ;
        childQ.push(root);
        TreeNode *currNode = root;
        while (!childQ.empty())
        {
            int size = childQ.size();
            for (int i = 0; i < size; i++)
            {
                currNode = childQ.front();
                childQ.pop();
                if (currNode->left)
                {
                    parentNodes[currNode->left->val] = currNode;
                    childQ.push(currNode->left);
                }
                if (currNode->right)
                {
                    parentNodes[currNode->right->val] = currNode;
                    childQ.push(currNode->right);
                }
            }
        }
    }
    vector<int> getNodesAtDistK(unordered_map<int, TreeNode *> parentNodes, TreeNode *target, int k)
    {
        queue<TreeNode *> nodesAtDist;
        unordered_map<int, bool> visitedNodes;
        nodesAtDist.push(target);
        visitedNodes[target->val] = true;
        while (!nodesAtDist.empty())
        {
            int size = nodesAtDist.size();
            if (k-- == 0)
                break;
            for (int i = 0; i < size; i++)
            {
                TreeNode *currNode = nodesAtDist.front();
                nodesAtDist.pop();
                if (currNode->left && !visitedNodes[currNode->left->val])
                {
                    nodesAtDist.push(currNode->left);
                    visitedNodes[currNode->left->val] = true;
                }
                if (currNode->right && !visitedNodes[currNode->right->val])
                {
                    nodesAtDist.push(currNode->right);
                    visitedNodes[currNode->right->val] = true;
                }
                if (parentNodes[currNode->val] && !visitedNodes[(parentNodes[currNode->val])->val])
                {
                    nodesAtDist.push(parentNodes[currNode->val]);
                    visitedNodes[(parentNodes[currNode->val])->val] = true;
                }
            }
        }
        vector<int> res;
        while (!nodesAtDist.empty())
        {
            res.push_back(nodesAtDist.front()->val);
            nodesAtDist.pop();
        }
        return res;
    }
    vector<int> distanceK(TreeNode *root, TreeNode *target, int k)
    {
        unordered_map<int, TreeNode *> parentNodes;
        parentNodes[root->val] = NULL;
        levelOrder(root, parentNodes);
        return getNodesAtDistK(parentNodes, target, k);
    }
};