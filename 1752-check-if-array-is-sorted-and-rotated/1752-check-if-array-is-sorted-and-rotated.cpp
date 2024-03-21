class Solution {
public:
    bool check(vector<int>& nums) {
        int len = nums.size(), count = 0;
        for (int i = 0; i < len; i++) {
            if (nums[i] > nums[(i + 1) % len])
                count++;
            if (count > 1)
                return 0;
        }
        return 1;
    }
};