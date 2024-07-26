class Solution {
    boolean dfs(int[] nums, int k, int[] sums, int idx, int maxSum) {
        if (idx >= nums.length) {
            for (int i = 1; i < k; i++)
                if (sums[i] != sums[i-1])
                    return false;
            return true;
        }
        for (int i = 0; i < k; i++) {
            if (sums[i] + nums[idx] <= maxSum) {
                sums[i] += nums[idx];
                if (dfs(nums, k, sums, idx+1, maxSum) == true)
                    return true;
                sums[i] -= nums[idx];
            }
            if (sums[i] == 0)
                break;
        }
        return false;
    }
    
    public boolean canPartitionKSubsets(int[] arr, int k) {
        Arrays.sort(arr);
        int[] nums = new int[arr.length];
        for (int i = arr.length-1; i >= 0; i--)
            nums[arr.length-1-i] = arr[i];
        int total = 0;
        for (int i = 0; i < nums.length; i++)
            total += nums[i];
        if (total % k != 0)
            return false;
        int[] sums = new int[k];
        return dfs(nums, k, sums, 0, total/k);
    }
}