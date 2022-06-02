class Solution {
public:
    int subarraysDivByK(vector<int>& nums, int k) {
        // vector<int> prefixSum(nums.size());
        // int sum = 0;
        // for (int i = 0; i < nums.size(); i++) {
        //     sum += nums[i];
        //     prefixSum[i] = sum;
        // }
        // for (int i: prefixSum) {
        //     cout << i << " ";
        // }
        // cout << endl;
        int count = 0;
        // for (int i = 0; i < nums.size(); i++) {
        //     for (int j = i; j < nums.size(); j++) {
        //         int subsetSum = 0;
        //         if (i == 0)
        //             subsetSum = prefixSum[j];
        //         else {
        //             subsetSum = prefixSum[j] - prefixSum[i-1];
        //         }
        //         if (subsetSum % k == 0)
        //             count++;
        //     }
        // }
        unordered_map<int, int> remMap;
        int sum = 0, rem = 0;
        remMap[0] = 1;
        for (int i = 0; i < nums.size(); i++) {
            sum += nums[i];
            rem = sum % k;
            rem = (rem < 0) ? rem + k: rem;
            if (remMap.find(rem) != remMap.end()) {
                count += remMap[rem];
                remMap[rem]++;
            }
            else {
                remMap[rem] = 1;
            }
        }
        return count;
    }
};