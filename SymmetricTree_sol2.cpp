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
    bool checkSym(TreeNode *l, TreeNode *r)
    {
        if (l == NULL || r == NULL)
            return (l == r);
        return (l->val == r->val) && checkSym(l->left, r->right) && checkSym(l->right, r->left);
    }
    bool isSymmetric(TreeNode *root)
    {
        return checkSym(root->left, root->right);
    }
};