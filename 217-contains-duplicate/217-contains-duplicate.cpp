class Solution {
public:
    bool containsDuplicate(vector<int>& nums) {
        unordered_map<long int, bool> count;
        for (int i = 0; i < nums.size(); i++) {
            if (count[nums[i]] == true)
                return true;
            count[nums[i]] = true;
        }
        return false;
    }
};