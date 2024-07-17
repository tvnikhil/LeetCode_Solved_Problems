class Solution {
    int dfs(int[] nums, int target, int idx, int sum, int cnt) {
        if (idx >= nums.length) {
            if (sum == target)
                return cnt+1;
            return cnt;
        }
        cnt = dfs(nums, target, idx+1, sum+nums[idx], cnt);
        cnt = dfs(nums, target, idx+1, sum-nums[idx], cnt);
        return cnt;
    }
    
    public int findTargetSumWays(int[] nums, int target) {
        int idx = 0, sum = 0, cnt = 0;
        cnt = dfs(nums, target, idx, sum, cnt);
        return cnt;
    }
}