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
    bool isSameTree(TreeNode *l, TreeNode *r)
    {
        if (l == NULL || r == NULL)
            return (l == r);
        return (l->val == r->val) && isSameTree(l->left, r->left) && isSameTree(l->right, r->right);
    }
    void mirror(TreeNode *root)
    {
        if (root == NULL)
            return;
        TreeNode *temp = root->right;
        root->right = root->left;
        root->left = temp;
        mirror(root->left);
        mirror(root->right);
    }
    bool isSymmetric(TreeNode *root)
    {
        mirror(root->right);
        return isSameTree(root->left, root->right);
    }
};