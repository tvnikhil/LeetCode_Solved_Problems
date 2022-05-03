class Solution {
public:
    vector<int> nextGreaterElements(vector<int>& nums) {
        vector<int> ans;
        for (int i = 0; i < nums.size(); i++) {
            bool flag = false;
            int k = i+1, j = 0;
            for (; ; k++) {
                // cout << (k%nums.size()) << " " << j << " " << k << endl;
                j = (k%nums.size());
                if (j == i) {
                    break;
                }
                if (nums[j] > nums[i]) {
                    flag = true;
                    ans.push_back(nums[j]);
                    break;
                }
            }
            if (flag == false)
                ans.push_back(-1);
        }
        return ans;
    }
};