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
    vector<vector<int>> allPaths;
    void preOrder(TreeNode *root, int targetSum, int currSum, vector<int> path)
    {
        if (root == NULL)
            return;
        currSum += root->val;
        path.push_back(root->val);
        if (root->left == NULL && root->right == NULL)
            if (targetSum == currSum)
                allPaths.push_back(path);
        preOrder(root->left, targetSum, currSum, path);
        preOrder(root->right, targetSum, currSum, path);
    }
    vector<vector<int>> pathSum(TreeNode *root, int targetSum)
    {
        vector<int> path;
        preOrder(root, targetSum, 0, path);
        return allPaths;
    }
};