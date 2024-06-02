class Solution {
    public int formSubArrays(int[] arr, int minSum) {
        int currSum = 0, parts = 1;
        for (int i = 0; i < arr.length; i++) {
            if (currSum + arr[i] <= minSum) {
                currSum += arr[i];
            }
            else {
                parts++;
                currSum = arr[i];
            }
        }
        return parts;
    }
    
    public int splitArray(int[] nums, int k) {
        int low = nums[0], high = nums[0];
        for (int i = 1; i < nums.length; i++) {
            low = Math.max(low, nums[i]);
            high += nums[i];
        }
        int ans = -1;
        while (low <= high) {
            int mid = (low + high) / 2;
            int parts = formSubArrays(nums, mid);
            if (parts <= k) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
}