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
#define MODVAL 1000000007
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

class TempNode
{
public:
    int data, depth;
    TempNode(int data, int depth)
    {
        this->data = data;
        this->depth = depth;
    }
};

bool compare(TempNode *i, TempNode *j)
{
    if (i->depth < j->depth)
        return 1;
    if (j->depth < i->depth)
        return 0;
    if (i->data < j->data)
        return 1;
    if (j->data < i->data)
        return 0;
    return 1;
}

class Solution
{
public:
    map<int, vector<TempNode *>> verticalLevels;
    void preOrderTraversalRecursive(TreeNode *root, int verticalLevelNumber, int depth)
    {
        if (root == NULL)
            return;
        TempNode *nn = new TempNode(root->val, depth);
        verticalLevels[verticalLevelNumber].push_back(nn);
        preOrderTraversalRecursive(root->left, verticalLevelNumber - 1, depth + 1);
        preOrderTraversalRecursive(root->right, verticalLevelNumber + 1, depth + 1);
    }
    vector<vector<int>> verticalTraversal(TreeNode *root)
    {
        preOrderTraversalRecursive(root, 0, 0);
        vector<vector<int>> verticalTree;
        for (auto i = verticalLevels.begin(); i != verticalLevels.end(); i++)
        {
            vector<TempNode *> sameVLevel((i->second).begin(), (i->second).end());
            sort(sameVLevel.begin(), sameVLevel.end(), compare);
            vector<int> temp;
            for (int itr = 0; itr < (int)sameVLevel.size(); itr++)
                temp.push_back(sameVLevel[itr]->data);
            verticalTree.push_back(temp);
        }
        return verticalTree;
    }
};