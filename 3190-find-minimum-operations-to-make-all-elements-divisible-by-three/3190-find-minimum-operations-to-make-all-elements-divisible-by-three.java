class Solution {
    public int minimumOperations(int[] nums) {
        int ans = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] % 3 != 0) {
                int rem = nums[i] % 3;
                ans += Math.min(rem, 3 - rem);
            }
        }
        return ans;
    }
}