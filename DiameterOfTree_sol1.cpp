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
    int maxDia = -1;
    int height(TreeNode *root)
    {
        if (root == NULL)
            return -1;
        int lh = 1 + height(root->left);
        int rh = 1 + height(root->right);
        return max(lh, rh);
    }
    void preOrder(TreeNode *root)
    {
        if (root == NULL)
            return;
        int lh = height(root->left), rh = height(root->right);
        maxDia = max(maxDia, lh + rh + 2);
        preOrder(root->left);
        preOrder(root->right);
    }
    int diameterOfBinaryTree(TreeNode *root)
    {
        preOrder(root);
        return maxDia;
    }
};