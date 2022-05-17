class Solution {
public:
    void moveZeroes(vector<int>& nums) {
        int left = 0, right = 1;
        while (left < nums.size() && right < nums.size()) {
            // cout << left << " " << right << endl;
            if (nums[left] == 0) {
                while (right < nums.size() && nums[right] == 0)
                    right++;
                if (right == nums.size())
                    right--;
                swap(nums[left], nums[right]);
                left++;
                right++;
            }
            else {
                left++;
                right++;
            }
        }
    }
};