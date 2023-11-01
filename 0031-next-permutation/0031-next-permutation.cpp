class Solution {
public:
    void nextPermutation(vector<int>& nums) {
        // Find longest prefix
        int idx = -1, n = nums.size();
        // find breaking point
        for (int i = n-2; i >= 0; i--) {
            if (nums[i] < nums[i + 1]) {
                idx = i;
                break;
            }
        }
        if (idx == -1) {
            reverse(nums.begin(), nums.end());
        }
        else {
            // find element greater than nums[idx] and swap
            for (int i = n-1; i > idx; i--) {
                if (nums[i] > nums[idx]) {
                    swap(nums[i], nums[idx]);
                    break;
                }
            }
            reverse(nums.begin()+idx+1, nums.end());
        }
    }
};