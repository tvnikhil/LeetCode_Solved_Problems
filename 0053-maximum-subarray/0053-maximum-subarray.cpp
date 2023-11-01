class Solution {
public:
    int maxSubArray(vector<int>& nums) {
        // [-2,1,-3,4,-1,2,1,-5,4]
        // [-2,-1,-4,0,-1,1,2,-3,1]
        vector<int> prefixSum;
        prefixSum.push_back(nums[0]);
        for (int i = 1; i < nums.size(); i++) {
            if (prefixSum[i-1] > 0)
                prefixSum.push_back(nums[i] + prefixSum[i-1]);
            else
                prefixSum.push_back(nums[i]);
        }
        return *max_element(prefixSum.begin(), prefixSum.end());
    }
};