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

class Solution {
public:
    vector<string> allPaths;
    void preOrder(TreeNode *root, string path)
    {
        if (root == NULL)
            return;
        path += to_string(root->val) + "->";
        if (root->left == NULL && root->right == NULL)
            allPaths.push_back(path.substr(0, path.length()-2));
        preOrder(root->left, path);
        preOrder(root->right, path);
    }
    vector<string> binaryTreePaths(TreeNode* root) {
        preOrder(root, "");
        return allPaths;
    }
};