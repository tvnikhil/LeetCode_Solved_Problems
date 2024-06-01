class Solution {
    public int sum(int[] arr, int div) {
        int res = 0;
        for (int i = 0; i < arr.length; i++) {
            res += Math.ceil((double) arr[i] / (double) div);
        }
        return res;
    }
    
    public int smallestDivisor(int[] nums, int threshold) {
        int maxi = nums[0];
        for (int i = 1; i < nums.length; i++)
            maxi = Math.max(maxi, nums[i]);
        int low = 1, high = maxi, ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int total = sum(nums, mid);
            if (total <= threshold) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}