#include<bits/stdc++.h>

class Solution {
public:
    vector<int> twoSum(vector<int>& nums, int target) {
        vector<int> temp(nums.begin(), nums.end());
        sort(temp.begin(), temp.end());
        vector<int> ansVec;
        int p1 = 0, p2 = nums.size() - 1;
        while (p1 <= p2)
        {
            if (temp[p1] + temp[p2] > target)
                p2--;
            else if (temp[p1] + temp[p2] < target)
                p1++;
            else
                break;
        }
        int a = temp[p1], b = temp[p2];
        for (int i = 0; i < nums.size(); i++)
        {
            if (a == nums[i])
                ansVec.push_back(i);
            else if (b == nums[i])
                ansVec.push_back(i);
            if (ansVec.size() == 2)
                break;
        }
        return ansVec;
    }
};