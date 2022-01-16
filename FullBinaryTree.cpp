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

TreeNode *insertNodeBST(TreeNode *root, int key)
{
    if (root == NULL)
    {
        TreeNode *nn = new TreeNode(key);
        return nn;
    }
    if (key < root->val)
        root->left = insertNodeBST(root->left, key);
    else
        root->right = insertNodeBST(root->right, key);
    return root;
}

TreeNode *constructBST(vector<int> arr, int nodeCount)
{
    TreeNode *root = new TreeNode(arr[0]);
    for (int i = 1; i < nodeCount; i++)
        root = insertNodeBST(root, arr[i]);
    return root;
}

bool checkFullBST(TreeNode *root)
{
    if (root == NULL)
        return true;
    bool flag = (root->right && root->left) || (!root->right && !root->left);
    return flag && checkFullBST(root->left) && checkFullBST(root->right);
}

int main()
{
    long int testcases;
    scanf("%ld", &testcases);
    while (testcases--)
    {
        int nodeCount;
        cin >> nodeCount;
        vector<int> arr(nodeCount);
        for (int i = 0; i < nodeCount; i++)
            cin >> arr[i];
        TreeNode *root = constructBST(arr, nodeCount);
        bool flag = checkFullBST(root);
        flag == false ? cout << "False" : cout << "True";
        cout << endl;
    }
    return 0;
}
