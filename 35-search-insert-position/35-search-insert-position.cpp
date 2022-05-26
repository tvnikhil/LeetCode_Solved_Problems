class Solution {
public:
    int searchInsert(vector<int>& nums, int target) {
        if (nums[nums.size()-1] < target)
            return nums.size();
        int low = 0, high = nums.size()-1, ans = 0, mid = 0;
        while (low <= high) {
            mid = (low+high)/2;
            if (target <= nums[mid]) {
                ans = mid;
                high = mid-1;
            }
            else {
                low = mid+1;
            }
        }
        return ans;
    }
};