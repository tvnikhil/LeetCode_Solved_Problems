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

vector<string> allPaths;

class TreeNode
{
public:
    int data;
    TreeNode *left;
    TreeNode *right;
    TreeNode(int d)
    {
        data = d;
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
    if (key < root->data)
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

void preOrder(TreeNode *root, string path)
{
    if (root == NULL)
        return;
    path += to_string(root->data);
    if (root->left == NULL && root->right == NULL)
        allPaths.push_back(path);
    preOrder(root->left, path);
    preOrder(root->right, path);
}

string findSum(string str1, string str2)
{
    if (str1.length() > str2.length())
        swap(str1, str2);
    string str = "";
    int n1 = str1.length(), n2 = str2.length();
    int diff = n2 - n1;
    int carry = 0;
    for (int i = n1 - 1; i >= 0; i--)
    {
        int sum = ((str1[i] - '0') + (str2[i + diff] - '0') + carry);
        str.push_back(sum % 10 + '0');
        carry = sum / 10;
    }
    for (int i = n2 - n1 - 1; i >= 0; i--)
    {
        int sum = ((str2[i] - '0') + carry);
        str.push_back(sum % 10 + '0');
        carry = sum / 10;
    }
    if (carry)
        str.push_back(carry + '0');
    reverse(str.begin(), str.end());
    return str;
}

long int mod(string num)
{
    long int res = 0;
    for (int i = 0; i < (int)num.length(); i++)
        res = (res * 10 + (int)num[i] - '0') % MODVAL;
    return res;
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
        allPaths.clear();
        preOrder(root, "");
        string sum = allPaths[0];
        for (int i = 1; i < (int)allPaths.size(); i++)
            sum = findSum(sum, allPaths[i]);
        cout << mod(sum) << endl;
    }
    return 0;
}
