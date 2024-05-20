class Solution {
    public int[] searchRange(int[] nums, int target) {
        int[] res = new int[2];
        int low = 0, high = nums.length - 1, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] <= target) {
                ans = mid;
                low = mid + 1;
            }
            else
                high = mid - 1;
        }
        if (ans != -1 && nums[ans] == target)
            res[1] = ans;
        else
            res[1] = -1;
        
        low = 0;
        high = nums.length - 1;
        ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (nums[mid] >= target) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        if (ans != -1 && nums[ans] == target)
            res[0] = ans;
        else
            res[0] = -1;
        return res;
    }
}