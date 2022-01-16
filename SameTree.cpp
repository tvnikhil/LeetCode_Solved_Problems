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
    bool checkPreOrderTraversal(TreeNode *p, TreeNode *q)
    {
        if (p == NULL || q == NULL)
            return p == q;
        bool t3 = (p->val == q->val);
        bool t1 = checkPreOrderTraversal(p->left, q->left);
        bool t2 = checkPreOrderTraversal(p->right, q->right);
        return (t3 && t1 && t2);
    }
    bool isSameTree(TreeNode *p, TreeNode *q)
    {
        if (checkPreOrderTraversal(p, q))
            return true;
        return false;
    }
};