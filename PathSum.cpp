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
    bool preOrder(TreeNode *root, int currSum, int targetSum)
    {
        if (root == NULL)
            return false;
        currSum += root->val;
        bool eq = false;
        if (root->left == NULL && root->right == NULL)
            eq = (currSum == targetSum);
        bool lTree = preOrder(root->left, currSum, targetSum);
        bool rTree = preOrder(root->right, currSum, targetSum);
        return (eq || lTree || rTree);
    }
    bool hasPathSum(TreeNode *root, int targetSum)
    {
        return preOrder(root, 0, targetSum);
    }
};