class Solution {
public:
    int removeDuplicates(vector<int>& nums) {
        int left = 1, right = 1;
        while (right < nums.size()) {
            if (nums[right-1] == nums[right])
                right++;
            else {
                nums[left] = nums[right];
                left++;
                right++;
            }
        }
        return left;
    }
};