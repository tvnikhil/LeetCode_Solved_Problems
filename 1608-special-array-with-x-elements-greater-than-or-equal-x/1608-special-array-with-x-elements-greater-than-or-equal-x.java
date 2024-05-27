import java.util.Arrays;

class Solution {
    public int lowerBound(int[] arr, int target) {
        int low = 0, high = arr.length - 1, ans = arr.length;
        while (low <= high) {
            int mid = (low + high) / 2;
            if (target <= arr[mid]) {
                ans = mid;
                high = mid - 1;
            }
            else
                low = mid + 1;
        }
        return ans;
    }
    
    public int specialArray(int[] nums) {
        // 0,0,3,4,4
        Arrays.sort(nums);
        for (int x = 0; x <= nums[nums.length - 1]; x++) {
            int pos = lowerBound(nums, x);
            int greaterElements = nums.length - pos;
            if (x == greaterElements)
                return x;
        }
        return -1;
    }
}