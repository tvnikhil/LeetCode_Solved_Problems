class Solution {
public:
    int missingNumber(vector<int>& nums) {
        unordered_map<int, bool> hm;
        for (int i = 0; i <= nums.size(); i++)
            hm[i] = false;
        for (int i = 0; i < nums.size(); i++)
            hm[nums[i]] = true;
        for (int i = 0; i <= nums.size(); i++)
            if (hm[i] == false)
                return i;
        return 0;
    }
};