class Solution {
    int ceil(int[] nums, int target) {
        int low = 0, high = nums.length-1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] > target) {
                ans = mid;
                high = mid-1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
    
    int floor(int[] nums, int target) {
        int low = 0, high = nums.length-1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] < target) {
                ans = mid;
                low = mid+1;
            }
            else
                high = mid-1;
        }
        return ans;
    }
    
    public int maximumCount(int[] nums) {
        int fPosIdx = ceil(nums, 0), fNegIdx = floor(nums, 0);
        if (fPosIdx == -1 && fNegIdx == -1)
            return 0;
        if (fPosIdx == -1)
            return fNegIdx+1;
        if (fNegIdx == -1)
            return nums.length-fPosIdx;
        return Math.max(fNegIdx+1, nums.length-fPosIdx);
    }
}