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
    bool isCompleteTree(TreeNode *root)
    {
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